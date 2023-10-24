package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 活动信息
 */
@Data
public class ActivityInfo implements Serializable {

    private Long activityId;

    private Integer activityType;

    private List<Integer> activityTags;

    private String thresholdUnit;

    private Integer actionType;

    private Double threshold;

    private Double discountsValue;

    private Double price;

    private Double breachRate;

    private Long actionId;

    private Integer imgHeight;

    private Integer imgWidth;

    private Integer isShow;

    private String promoteMsg;

    private Integer promote_type;

    private String imgUrl;

    private String url;

    private boolean typeStore;

    private Long startTime;

    private Long endTime;

    public static ActivityInfo get() {
        ActivityInfo dto = new ActivityInfo();
        dto.setActivityId(0L);
        dto.setActivityType(0);
        dto.setActivityTags(new ArrayList<>());
        dto.setThresholdUnit("");
        dto.setActionType(0);
        dto.setThreshold(0.0D);
        dto.setDiscountsValue(0.0D);
        dto.setPrice(0.0D);
        dto.setBreachRate(0.0D);
        dto.setActionId(0L);
        dto.setImgHeight(0);
        dto.setImgWidth(0);
        dto.setIsShow(0);
        dto.setPromoteMsg("");
        dto.setPromote_type(0);
        dto.setImgUrl("");
        dto.setUrl("");
        dto.setTypeStore(false);
        dto.setStartTime(0L);
        dto.setEndTime(0L);
        return dto;
    }

}
