package com.wanglook01.service;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.ProductDTO;
import com.wanglook01.dto.ProductQueryDTO;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class SkuService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    //增删改查商品信息
    public ResponseResult add(ProductDTO dto) {
        //文档id不指定
        IndexRequest request = new IndexRequest(EsConstant.INDEX_SKU).source(JsonUtil.toJson(dto), XContentType.JSON);
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


    public ResponseResult addBatch(List<ProductDTO> dtoList) {
        //文档id和skuId相同
        BulkRequest bulkRequest = new BulkRequest();
        for (ProductDTO dto : dtoList) {
            bulkRequest.add(new IndexRequest(EsConstant.INDEX_SKU).source(JsonUtil.toJson(dto), XContentType.JSON));
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


    public ResponseResult delete(ProductQueryDTO dto) {
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

    public ResponseResult update(ProductDTO dto) {
        //指定文档id
        UpdateRequest request = new UpdateRequest(EsConstant.INDEX_SKU, dto.getId()).doc(JsonUtil.toJson(dto), XContentType.JSON);
        //执行插入操作
        try {
            UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("Document update successfully, ID: " + response.getId());
            } else {
                log.info("Failed to update the document");
            }
            return ResponseResult.success(dto.getId());
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("更新失败");
        }
    }


    public ResponseResult search(ProductQueryDTO queryDTO) {
        switch (queryDTO.getAction()) {
            case "term":
                return this.term(queryDTO);
            case "range":
                return this.range(queryDTO);
            case "match":
                return this.match(queryDTO);
            case "multiMatch":
                return this.multiMatch(queryDTO);
            default:
                return ResponseResult.error("action异常");
        }
    }


    public ResponseResult match(ProductQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //searchRequest.source().query(QueryBuilders.matchQuery("brand", queryDTO.getBrand()).analyzer("ik_smart")).size(1000);
            searchRequest.source().query(QueryBuilders.matchQuery("skuName", queryDTO.getSkuName()).analyzer("ik_smart")).size(1000);

            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult multiMatch(ProductQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.multiMatchQuery(queryDTO.getSkuName(), "skuName", "origin.farmName")).size(1000);

            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult range(ProductQueryDTO queryDTO) {
        //
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice()));

            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //精准查询
    public ResponseResult term(ProductQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.termQuery("brand", queryDTO.getBrand()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult matchAll(ProductQueryDTO queryDTO) {
        //
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.matchAllQuery().queryName("skuName")).size(1000);

            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
