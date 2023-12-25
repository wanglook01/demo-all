package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdActivityDTO implements Serializable {

    private Long activityId;

    private Integer activityType;

    private List<Integer> activityTags;

    private List<ActivityTagDTO> activityTagInfos;

    private Long actionId;

    private Integer canBuyNum;

    private Long opActivityId;

    private String startTimeStr;

    private String endTimeStr;

    private String tinyShopSuitName;

    private Long ssu_id;

    private Long sku_id;

    private String name;

    private String img_url;

    private String original_price;

    private Integer num;

    private String total_price;

    private String total_format;

    private String ssu_format;

    private Integer format_type;

    private String format_msg;

    private String ssu_suit_price;

    private Long activityStartTime;

    private Long activityEndTime;

    public static ProdActivityDTO get() {
        ProdActivityDTO dto = new ProdActivityDTO();
        dto.setActivityId(0L);
        dto.setActivityType(0);
        dto.setActivityTags(new ArrayList<>());
        dto.setActivityTagInfos(new ArrayList<>());
        dto.setActionId(0L);
        dto.setCanBuyNum(0);
        dto.setOpActivityId(0L);
        dto.setStartTimeStr("");
        dto.setEndTimeStr("");
        dto.setTinyShopSuitName("");
        dto.setSsu_id(0L);
        dto.setSku_id(0L);
        dto.setName("");
        dto.setImg_url("");
        dto.setOriginal_price("");
        dto.setNum(0);
        dto.setTotal_price("");
        dto.setTotal_format("");
        dto.setSsu_format("");
        dto.setFormat_type(0);
        dto.setFormat_msg("");
        dto.setSsu_suit_price("");
        dto.setActivityStartTime(0L);
        dto.setActivityEndTime(0L);
        return dto;
    }


}
