package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class AttrInfoDTO implements Serializable {

    private String attr_code;

    private String attr_value;

    private String attr_desc;

    private String is_display;

    private String display_name;

    public static AttrInfoDTO get() {
        AttrInfoDTO dto = new AttrInfoDTO();
        dto.setAttr_code("");
        dto.setAttr_value("");
        dto.setAttr_desc("");
        dto.setIs_display("");
        dto.setDisplay_name("");
        return dto;
    }
}
