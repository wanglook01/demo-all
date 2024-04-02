package com.wanglook01.dto;

import lombok.Data;

@Data
public class SkuQueryDTO {

    private String action;

    private String id;

    private Integer skuId;

    // 商品名称
    private String skuName;

    private Integer minPrice;

    private Integer maxPrice;

    private String brand;

    private String analyzer;

    private String description;

    private String field;
}