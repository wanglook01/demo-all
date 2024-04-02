package com.wanglook01.service;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.ProductQueryDTO;
import com.wanglook01.dto.SkuDTO;
import com.wanglook01.dto.SkuQueryDTO;
import com.wanglook01.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SkuService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    //增删改查商品信息
    public ResponseResult add(SkuDTO dto) {
        //指定文档id或者不指定均可
        IndexRequest request = new IndexRequest()
                .index(EsConstant.INDEX_SKU)
                .id(dto.getSkuId().toString())
                .source(JsonUtil.toJson(dto), XContentType.JSON);
        //执行插入操作
        try {
            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.CREATED || response.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("Document indexed successfully, ID: " + response.getId());
            } else {
                log.info("Failed to index the document");
            }
            return ResponseResult.success(dto);
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("添加失败");
        }
    }


    public ResponseResult addBatch(List<SkuDTO> dtoList) {
        //文档id和skuId相同
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuDTO dto : dtoList) {
            bulkRequest.add(new IndexRequest(EsConstant.INDEX_SKU).id(dto.getSkuId().toString()).source(JsonUtil.toJson(dto), XContentType.JSON));
        }
        //执行插入操作
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


    public ResponseResult delete(SkuQueryDTO dto) {
        //指定文档id
        DeleteRequest request = new DeleteRequest(EsConstant.INDEX_SKU).id(dto.getId());
        //执行插入操作
        try {
            DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.DELETED || response.getResult() == DocWriteResponse.Result.DELETED) {
                log.info("Document delete successfully, ID: " + response.getId());
            } else {
                log.info("Failed to delete the document");
            }
            return ResponseResult.success(dto.getId());
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("删除失败");
        }
    }

    public ResponseResult updateAll(SkuDTO dto) {
        //指定文档id
        String json = JsonUtil.toJson(dto);
        log.info("Document json: {}", json);
        UpdateRequest request = new UpdateRequest(EsConstant.INDEX_SKU, dto.getSkuId().toString()).doc(json, XContentType.JSON);
        //执行插入操作
        try {
            UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("Document update successfully, ID: " + response.getId());
            } else {
                log.info("Failed to update the document");
            }
            return ResponseResult.success(dto.getSkuId());
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("更新失败");
        }
    }

    public ResponseResult updateSingle(SkuDTO dto) {
        Map<String, Object> fieldsToUpdate = new HashMap<>();
        fieldsToUpdate.put("skuName", dto.getSkuName());
        String json = JsonUtil.toJson(fieldsToUpdate);
        log.info("Document json: {}", json);
        //指定文档id
        UpdateRequest request = new UpdateRequest(EsConstant.INDEX_SKU, dto.getSkuId().toString()).doc(json, XContentType.JSON);
        //执行插入操作
        try {
            UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("Document update successfully, ID: " + response.getId());
            } else {
                log.info("Failed to update the document");
            }
            return ResponseResult.success(dto.getSkuId());
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("更新失败");
        }
    }
}
