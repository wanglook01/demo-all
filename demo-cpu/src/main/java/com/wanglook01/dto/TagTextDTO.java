package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class TagTextDTO implements Serializable {

    private Integer tag_type;

    private Integer corner_radius;

    private String text_color;

    private String frame_color;

    private String background_color;

    private String tag;

    private Long id;

    private Double sort;

    private String msg;

    private String attr_code;

    private Integer is_show;

    private Long activityId;

    private String url;

    private String threshold_tag;

    private Integer is_copywriting;

    private String background_start_color;

    private String background_end_color;

    private Integer is_all_buy_label;

    private int javaEmptyObjMark;

    private String start_color;

    private String end_color;

    private Integer is_score;

    private String scoreDesc;

    private String score;

    private Integer text_size;

    private String tagTinyImgUrl;

    public static TagTextDTO get() {
        TagTextDTO dto = new TagTextDTO();
        dto.setTag_type(0);
        dto.setCorner_radius(0);
        dto.setText_color("");
        dto.setFrame_color("");
        dto.setBackground_color("");
        dto.setTag("");
        dto.setId(0L);
        dto.setSort(0.0D);
        dto.setMsg("");
        dto.setAttr_code("");
        dto.setIs_show(0);
        dto.setActivityId(0L);
        dto.setUrl("");
        dto.setThreshold_tag("");
        dto.setIs_copywriting(0);
        dto.setBackground_start_color("");
        dto.setBackground_end_color("");
        dto.setIs_all_buy_label(0);
        dto.setJavaEmptyObjMark(0);
        dto.setStart_color("");
        dto.setEnd_color("");
        dto.setIs_score(0);
        dto.setScoreDesc("");
        dto.setScore("");
        dto.setText_size(0);
        dto.setTagTinyImgUrl("");
        return dto;
    }

}
