package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wanglook01.util.RandomUtil;

import java.io.Serializable;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayTagDTO implements Serializable {

    private String tagCode;
    private String tagName;
    private Integer sort;

    public static DisplayTagDTO get(){
        DisplayTagDTO dto = new DisplayTagDTO();
        dto.setTagCode(RandomUtil.randomStr(2));
        dto.setTagName(RandomUtil.randomStr(10));
        dto.setSort(RandomUtil.randomInteger());
        return dto;
    }

}
