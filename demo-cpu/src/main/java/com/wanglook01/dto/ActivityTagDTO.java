package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 活动标签
 */
@Data
public class ActivityTagDTO implements Serializable {

    private Integer id;

    private String categoryName;

    private String imageUrl;

}
