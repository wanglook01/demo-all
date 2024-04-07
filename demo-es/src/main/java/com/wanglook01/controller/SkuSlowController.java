package com.wanglook01.controller;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.SkuDTO;
import com.wanglook01.dto.SkuQueryDTO;
import com.wanglook01.util.ConstUtil;
import com.wanglook01.util.JsonUtil;
import com.wanglook01.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * sku_index_slow，3分片3副本
 * {"mappings":{"properties":{"skuId":{"type":"long"},"skuName":{"type":"text","analyzer":"ik_max_word","fields":{"raw":{"type":"keyword"}}},"brand":{"type":"keyword"},"stock":{"type":"integer"},"status":{"type":"integer"}}},"settings":{"index":{"number_of_shards":3,"number_of_replicas":3}}}
 */
@RestController
@RequestMapping("/skuSlow")
@Slf4j
public class SkuSlowController {

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @RequestMapping("/initSkuIndex0")
    public ResponseResult initSkuIndex0() {
        BulkRequest bulkRequest = new BulkRequest();
        //生成json
        for (int i = 0; i < 1000; i++) {
            SkuDTO skuDTO = new SkuDTO();
            skuDTO.setSkuId((long) MathUtil.generateRandomBetween10000And99999());
            skuDTO.setSkuName(ConstUtil.getSkuName());
            skuDTO.setBrand(ConstUtil.getBrand());
            skuDTO.setStock(MathUtil.generateRandomBetween100And999());
            skuDTO.setStatus(MathUtil.generateRandomBetween0And14());
            bulkRequest.add(new IndexRequest(EsConstant.INDEX_SLOW_SKU)
                    .id(skuDTO.getSkuId().toString())
                    .source(JsonUtil.toJson(skuDTO), XContentType.JSON));
        }
        //发送请求
        try {
            BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            if (!response.hasFailures()) {
                log.info("Document indexed successfully,size:{}", response.getItems().length);
            } else {
                log.info("Failed to index the document");
            }
            return ResponseResult.success("success");
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("添加失败");
        }
    }


    @RequestMapping("/search")
    public ResponseResult search(@RequestBody SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SLOW_SKU);
            //构建builder
            BoolQueryBuilder bb = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchQuery("skuName", queryDTO.getSkuName()))
                    .must(QueryBuilders.rangeQuery("stock").gte(queryDTO.getMinStock()).lte(queryDTO.getMaxStock()));
            searchRequest.source().query(bb);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
