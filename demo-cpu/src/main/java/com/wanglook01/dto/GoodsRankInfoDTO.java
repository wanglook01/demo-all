package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsRankInfoDTO implements Serializable {

    private String tag;

    private Integer rankLabelType;

    private Integer rankLabelValue;

    private String imgUrl;

    private String tinyImgUrl;

    private String linkUrl;

    private Integer corner_radius;

    private String text_color;

    private String background_color;

    public static GoodsRankInfoDTO get() {
        GoodsRankInfoDTO dto = new GoodsRankInfoDTO();
        dto.setTag("");
        dto.setRankLabelType(0);
        dto.setRankLabelValue(0);
        dto.setImgUrl("");
        dto.setTinyImgUrl("");
        dto.setLinkUrl("");
        dto.setCorner_radius(0);
        dto.setText_color("");
        dto.setBackground_color("");
        return dto;
    }

}
