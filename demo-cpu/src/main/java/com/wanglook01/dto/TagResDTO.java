package com.wanglook01.dto;


import lombok.Data;

@Data
public class TagResDTO {

    private Integer tagType;

    private String tag;

    private String frameColor;

    private String backgroundColor = "#ffffff";

    private String bgColorStart;
    private String bgColorEnd;

    private String textColor;

    private Integer cornerRadius;

    private String tagTinyImgUrl;

    private Integer textSize;

    private String tagImg;

    private String sourceFrom;

    public static TagResDTO get() {
        return new TagResDTO();
    }

}

