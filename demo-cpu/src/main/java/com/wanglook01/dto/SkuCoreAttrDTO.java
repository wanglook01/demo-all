package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wanglook01.util.RandomUtil;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuCoreAttrDTO implements Serializable {

    private String attrType;
    private String attrValue;
    private Integer sort;

    public static SkuCoreAttrDTO get(){
        SkuCoreAttrDTO dto = new SkuCoreAttrDTO();
        dto.setSort(RandomUtil.randomInteger());
        return dto;
    }

}
