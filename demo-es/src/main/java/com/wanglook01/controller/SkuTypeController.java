package com.wanglook01.controller;

import com.wanglook01.constant.EsConstant;
import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.SkuTypeDTO;
import com.wanglook01.util.ConstUtil;
import com.wanglook01.util.JsonUtil;
import com.wanglook01.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sku_index_type，1分片1副本
 * {"mappings":{"properties":{"sku_id":{"type":"keyword"},"sku_name":{"type":"text"},"ssu_id":{"type":"keyword"},"package":{"type":"text"},"sku_object":{"type":"object","properties":{"id":{"type":"integer"},"name":{"type":"text"},"address":{"type":"object","properties":{"city":{"type":"keyword"},"region":{"type":"text"}}}}},"sku_nested":{"type":"nested","properties":{"id":{"type":"integer"},"name":{"type":"text"},"address":{"type":"nested","properties":{"city":{"type":"keyword"},"region":{"type":"text"}}}}},"sku_ssu":{"type":"join","relations":{"sku_id":"ssu_id"}}}}}
 * sku_ssu
 */
@RestController
@RequestMapping("/skuType")
@Slf4j
public class SkuTypeController {

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @RequestMapping("/initSkuType")
    public ResponseResult initSkuType() {
        try {
            //添加父文档：正常添加
            List<String> parentIds = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                long skuId = MathUtil.generateRandomBetween10000And99999();
                String docId = "sku_" + skuId;
                String skuName = ConstUtil.getSkuName();
                SkuTypeDTO.AddressDTO addressDTO = new SkuTypeDTO.AddressDTO(ConstUtil.getRegion(), ConstUtil.getFarm());
                SkuTypeDTO.SkuTypeInnerDTO innerDTO = new SkuTypeDTO.SkuTypeInnerDTO(skuId, skuName, addressDTO);
                //
                Map<String, Object> parentDoc = new HashMap<>();
                parentDoc.put("sku_id", skuId);
                parentDoc.put("sku_name", skuName);
                parentDoc.put("sku_object", innerDTO);  // 填充父文档的sku_object字段
                parentDoc.put("sku_nested", innerDTO);  // 填充父文档的sku_nested字段
                //
                IndexRequest parentRequest = new IndexRequest(EsConstant.SKU_TYPE_INDEX).id(docId).source(JsonUtil.toJson(parentDoc), XContentType.JSON);
                IndexResponse parentResponse = restHighLevelClient.index(parentRequest, RequestOptions.DEFAULT);
                log.info("插入父文档：{}", parentResponse.getResult());
                parentIds.add(docId);
            }
            //添加子文档，需要指定对应关系,子文档也可以使用其余的字段,必须指定rooting
            for (String parentId : parentIds) {
                long ssuId = MathUtil.generateRandomBetween100And999();
                Map<String, Object> childDoc = new HashMap<>();
                childDoc.put("ssu_id", ssuId);
                childDoc.put("package", "25斤");
                //childDoc.put("sku_object", null);  // 填充子文档的sku_object字段
                //childDoc.put("sku_nested", null);  // 填充子文档的sku_nested字段
                Map<String, Object> joinField = new HashMap<>();
                joinField.put("name", "ssu_id");  // 子类型名
                joinField.put("parent", parentId);  // 父文档的sku_id
                childDoc.put("sku_ssu", joinField);
                IndexRequest childRequest = new IndexRequest(EsConstant.SKU_TYPE_INDEX).id("ssu_" + ssuId)
                        .source(JsonUtil.toJson(childDoc), XContentType.JSON).routing(parentId);
                IndexResponse childResponse = restHighLevelClient.index(childRequest, RequestOptions.DEFAULT);
                log.info("插入子文档：{}", childResponse.getResult());
            }
        } catch (Exception e) {
            log.error("error", e);
            return ResponseResult.error("error");
        }
        return ResponseResult.success("success");
    }

}
