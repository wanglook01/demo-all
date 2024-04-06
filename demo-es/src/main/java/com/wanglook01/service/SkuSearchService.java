package com.wanglook01.service;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.SkuQueryDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

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
            case "idsQuery":
                return this.idsQuery(queryDTO);


            case "boolQuery":
                return this.boolQuery(queryDTO);
            case "boostingQuery":
                return this.boostingQuery(queryDTO);
            case "constantScoreQuery":
                return this.constantScoreQuery(queryDTO);
            case "functionScoreQuery":
                return this.functionScoreQuery(queryDTO);
            case "disMaxQuery":
                return this.disMaxQuery(queryDTO);


            case "sort":
                return this.sort(queryDTO);
            case "pageQuery":
                return this.pageQuery(queryDTO);


            case "filter":
                return this.filter(queryDTO);


            case "highlight":
                return this.highlight(queryDTO);
            default:
                return ResponseResult.error("action异常");
        }
    }

    public ResponseResult matchAllQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU).searchType(SearchType.DFS_QUERY_THEN_FETCH);
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

    /**
     *
     */
    public ResponseResult matchPhraseQuery(SkuQueryDTO queryDTO) {
        try {
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            QueryBuilder queryBuilder;
            if (queryDTO.getSlop() != null && queryDTO.getSlop() != 0) {
                queryBuilder = QueryBuilders.matchPhraseQuery("description", queryDTO.getDescription())
                        .analyzer(queryDTO.getAnalyzer()).slop(queryDTO.getSlop());
            } else {
                queryBuilder = QueryBuilders.matchPhraseQuery("description", queryDTO.getDescription())
                        .analyzer(queryDTO.getAnalyzer());
            }
            searchRequest.source().query(queryBuilder).size(1000);
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

    public ResponseResult idsQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.source().query(QueryBuilders.idsQuery().addIds(queryDTO.getIds().toArray(new String[]{})));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * {
     * "action": "boolQuery",
     * "actionNum":"mix",
     * "brand": "绿叶农业",
     * "minPrice": 1,
     * "maxPrice":20,
     * "minStock": 3001,
     * "maxStock":500,
     * "skuId":1001
     * }
     *
     * @param queryDTO
     * @return
     */
    public ResponseResult boolQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //构建builder
            BoolQueryBuilder bb = null;
            if (Objects.equals(queryDTO.getActionDetail(), "must")) {
                bb = QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("brand", queryDTO.getBrand()))
                        .must(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice()));
            } else if (Objects.equals(queryDTO.getActionDetail(), "should")) {
                bb = QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("brand", queryDTO.getBrand()))
                        .should(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice()))
                        .minimumShouldMatch(2);
            } else if (Objects.equals(queryDTO.getActionDetail(), "mix")) {
                bb = QueryBuilders.boolQuery()
                        .must(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice()))
                        .should(QueryBuilders.rangeQuery("stock").gte(queryDTO.getMinStock()).lte(queryDTO.getMaxStock()))
                        .should(QueryBuilders.termQuery("skuId", queryDTO.getSkuId()))
                        .minimumShouldMatch(1);
            } else if (Objects.equals(queryDTO.getActionDetail(), "filter")) {
                bb = QueryBuilders.boolQuery()
                        .filter(QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice()));
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


    public ResponseResult boostingQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //构建builder
            MatchQueryBuilder positive = QueryBuilders.matchQuery("description", queryDTO.getDescription());
            RangeQueryBuilder negative = QueryBuilders.rangeQuery("price").gte(queryDTO.getMinPrice()).lte(queryDTO.getMaxPrice());
            searchRequest.source().query(QueryBuilders.boostingQuery(positive, negative).negativeBoost(0.5f));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult constantScoreQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            //构建builder
            MatchQueryBuilder positive = QueryBuilders.matchQuery("description", queryDTO.getDescription());
            searchRequest.source().query(QueryBuilders.constantScoreQuery(positive));
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult functionScoreQuery(SkuQueryDTO queryDTO) {
        try {
            //基础查询
            QueryBuilder queryBuilder = QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer());
            //打分1，随机值
            /*FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(ScoreFunctionBuilders.randomFunction())};*/
            //打分2，field_value_factor
            /*FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(ScoreFunctionBuilders.fieldValueFactorFunction("price")
                            .factor(2).modifier(FieldValueFactorFunction.Modifier.SQUARE))};*/
            //打分3：衰减函数,为啥price就是不行呢？
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder(ScoreFunctionBuilders.linearDecayFunction("price", 25F, 100F, 2F))};
            //打分4：
            /*FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[2];
            filterFunctionBuilders[0] = new FunctionScoreQueryBuilder.FilterFunctionBuilder(ScoreFunctionBuilders.randomFunction());
            filterFunctionBuilders[1] = new FunctionScoreQueryBuilder.FilterFunctionBuilder(ScoreFunctionBuilders.weightFactorFunction(0.5F));*/
            //
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder, functions)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .boostMode(CombineFunction.REPLACE);
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH).source().query(functionScoreQueryBuilder);
            //
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult disMaxQuery(SkuQueryDTO queryDTO) {
        try {
            //基础查询
            QueryBuilder queryBuilder = null;
            switch (queryDTO.getActionDetail()) {
                case "should":
                    queryBuilder = QueryBuilders.boolQuery()
                            .should(QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer()))
                            .should(QueryBuilders.matchQuery("skuName", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer()))
                            .minimumShouldMatch(1);
                    break;
                case "dis":
                    queryBuilder = QueryBuilders.disMaxQuery()
                            .add(QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer()))
                            .add(QueryBuilders.matchQuery("skuName", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer()));
                    break;
                default:
                    throw new RuntimeException("error");

            }
            //
            SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX_SKU);
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH).source().query(queryBuilder);
            //
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
            QueryBuilder match = QueryBuilders.matchQuery("description", queryDTO.getDescription());
            if ("sort".equals(queryDTO.getActionDetail())) {
                searchRequest.source().query(match).sort("price", SortOrder.DESC);
            } else {
                searchRequest.source().query(match);
            }

            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseResult pageQuery(SkuQueryDTO queryDTO) {
        try {
            SearchRequest searchRequest = new SearchRequest();
            //分页1
            switch (queryDTO.getActionDetail()) {
                case "fromSize":
                    int from = (queryDTO.getPageNo() - 1) * queryDTO.getPageSize();
                    QueryBuilder match = QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer());
                    searchRequest.indices(EsConstant.INDEX_SKU)
                            .source(SearchSourceBuilder.searchSource()
                                    .query(match)
                                    .from(from).size(queryDTO.getPageSize())
                            );
                    break;
                case "searchAfter":
                    QueryBuilder matchQuery = QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer());
                    SearchSourceBuilder sourceBuilder = SearchSourceBuilder.searchSource()
                            .query(matchQuery)
                            .sort(SortBuilders.fieldSort("price").order(SortOrder.DESC))
                            .sort(SortBuilders.scoreSort().order(SortOrder.DESC))
                            .from((queryDTO.getPageNo() - 1) * queryDTO.getPageSize())
                            .size(queryDTO.getPageSize());
                    if (!CollectionUtils.isEmpty(queryDTO.getSortValues())) {
                        sourceBuilder.searchAfter(queryDTO.getSortValues().toArray(new Object[0]));
                    }
                    searchRequest.indices(EsConstant.INDEX_SKU).source(sourceBuilder);
                    break;
                case "scroll":
                    QueryBuilder matchQuery2 = QueryBuilders.matchQuery("description", queryDTO.getDescription()).analyzer(queryDTO.getAnalyzer());
                    searchRequest.indices(EsConstant.INDEX_SKU)
                            .source(SearchSourceBuilder.searchSource().query(matchQuery2).size(queryDTO.getPageSize()))
                            .scroll(TimeValue.MINUS_ONE);
                    //如果有scrollId,这里单独处理了
                    if (StringUtils.hasLength(queryDTO.getScrollId())) {
                        SearchScrollRequest searchScrollRequest = new SearchScrollRequest(queryDTO.getScrollId());
                        searchScrollRequest.scroll(TimeValue.MINUS_ONE);
                        SearchResponse searchResponse = restHighLevelClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);
                        return ResponseResult.success(searchResponse.getHits(), searchResponse.getScrollId());
                    }
                    break;
                default:
                    throw new RuntimeException("error");
            }
            // 执行查询
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 处理响应
            return ResponseResult.success(searchResponse.getHits(), searchResponse.getScrollId());
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
