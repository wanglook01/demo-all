package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponDTO implements Serializable {

    private Long couponDetailId;

    private Integer couponType;

    private Integer couponConditionType;

    private Integer startTime;

    private Integer endTime;

    private Integer useTime;

    private Double couponValue;

    private Double threshold;

    private Integer couponStatus;

    private Integer status;

    private String displayName;

    private String description;

    private List<String> patters;

    private Integer systemType;

    private Integer cT;

    private Integer expireType;

    private Integer receive_status;

    private Integer canBuyNum;

    private Integer triggerCount;

    private Integer activityId;
    private Integer actionId;
    private String sign;

    private Long couponModelId;

    private List<Long> popIds;

    public static CouponDTO get() {
        CouponDTO dto = new CouponDTO();
        dto.setCouponDetailId(0L);
        dto.setCouponType(0);
        dto.setCouponConditionType(0);
        dto.setStartTime(0);
        dto.setEndTime(0);
        dto.setUseTime(0);
        dto.setCouponValue(0.0D);
        dto.setThreshold(0.0D);
        dto.setCouponStatus(0);
        dto.setStatus(0);
        dto.setDisplayName("");
        dto.setDescription("");
        dto.setPatters(new ArrayList<>());
        dto.setSystemType(0);
        dto.setCT(0);
        dto.setExpireType(0);
        dto.setReceive_status(0);
        dto.setCanBuyNum(0);
        dto.setTriggerCount(0);
        dto.setActivityId(0);
        dto.setActionId(0);
        dto.setSign("");
        dto.setCouponModelId(0L);
        dto.setPopIds(new ArrayList<>());
        return dto;
    }


}
