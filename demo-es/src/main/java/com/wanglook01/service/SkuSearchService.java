package com.wanglook01.service;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.SkuQueryDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SkuSearchService {


    @Resource
    private RestHighLevelClient restHighLevelClient;


    public ResponseResult search(SkuQueryDTO queryDTO) {
        switch (queryDTO.getAction()) {
            case "matchAllQuery":
                return this.matchAllQuery(queryDTO);
            case "matchQuery":
                return this.matchQuery(queryDTO);
            case "matchPhraseQuery":
                return this.matchPhraseQuery(queryDTO);
            case "matchPhrasePrefixQuery":
                return this.matchPhrasePrefixQuery(queryDTO);
            case "multiMatchQuery":
                return this.multiMatchQuery(queryDTO);
            case "termQuery":
                return this.termQuery(queryDTO);
            case "termsQuery":
                return this.termsQuery(queryDTO);
            case "rangeQuery":
                return this.rangeQuery(queryDTO);
            case "existsQuery":
                return this.existsQuery(queryDTO);
            case "prefixQuery":
                return this.prefixQuery(queryDTO);
            case "wildcardQuery":
                return this.wildcardQuery(queryDTO);


            case "bool":
                return this.bool(queryDTO);
            case "filter":
                return this.filter(queryDTO);
            case "sort":
                return this.sort(queryDTO);
            case "searchAfter":
                return this.searchAfter(queryDTO);
            case "highlight":
                return this.highlight(queryDTO);
            default:
                return ResponseResult.error("action异常");
        }
    }

    public ResponseResult matchAllQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //这个会出现空指针，indices使用source()方法的时候，缺少SearchSourceBuilder对象，返回null，因此报NPE
            //searchRequest.indices(EsConstant.INDEX_SKU).source().query(QueryBuilders.matchAllQuery());
            searchRequest.source().query(QueryBuilders.matchAllQuery().boost(1.4F));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult matchQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //本质上keyword也是一个分词器，只不过这个分词器，是按照原本的面貌做的分词，就只有一个分词
            //searchRequest.source().query(QueryBuilders.matchQuery("brand", queryDTO.getBrand()).analyzer("ik_smart")).size(1000);
            searchRequest.source().query(QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer())).size(1000);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult matchPhraseQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.matchPhraseQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer())).size(1000);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult matchPhrasePrefixQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.matchPhrasePrefixQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer())).size(1000);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult multiMatchQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.multiMatchQuery(queryDTO.getDescription(), "skuName", "description")).size(1000);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //精准查询
    public ResponseResult termQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //searchRequest.source().query(QueryBuilders.termQuery("skuName.row", queryDTO.getSkuName()));
            searchRequest.source().query(QueryBuilders.termQuery("skuName", queryDTO.getSkuName()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult termsQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.termsQuery("skuName.row", queryDTO.getBrand(), queryDTO.getSkuName()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult rangeQuery(SkuQueryDTO queryDTO) {
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


    public ResponseResult existsQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.existsQuery(queryDTO.getField()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult prefixQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.prefixQuery(queryDTO.getField(), queryDTO.getSkuName()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult wildcardQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.wildcardQuery(queryDTO.getField(), queryDTO.getSkuName()));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult bool(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            BoolQueryBuilder bb = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("brand", queryDTO.getBrand()))
                    .must(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()));
            if (queryDTO.getSkuName() != null && !queryDTO.getSkuName().isEmpty()) {
                bb.should(QueryBuilders.matchQuery("skuName", queryDTO.getSkuName())).minimumShouldMatch(1);
            }
            searchRequest.source().query(bb);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult matchAll(SkuQueryDTO queryDTO) {
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


    public ResponseResult filter(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            BoolQueryBuilder must = QueryBuilders.boolQuery()
                    .must(QueryBuilders.termQuery("brand", "三只松鼠"))
                    .must(QueryBuilders.matchQuery("skuName", "味"));
            searchRequest.source().postFilter(must);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult sort(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            BoolQueryBuilder must = QueryBuilders.boolQuery()
                    .must(QueryBuilders.termQuery("brand", "三只松鼠"));
            searchRequest.source().query(must).sort("price", SortOrder.ASC).from(1).size(1);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult searchAfter(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //
            searchRequest.source().query(QueryBuilders.matchAllQuery()).sort("skuId", SortOrder.ASC).searchAfter(new Integer[]{queryDTO.getSkuId()}).size(3);
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseResult highlight(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //
            searchRequest.source()
                    .query(QueryBuilders.matchQuery("description", "4K超清家用投影仪"))
                    .highlighter(new HighlightBuilder().field("description").preTags("<em>").postTags("</em>"));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
