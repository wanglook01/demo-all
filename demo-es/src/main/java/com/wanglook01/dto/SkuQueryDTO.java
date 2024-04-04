package com.wanglook01.dto;

import lombok.Data;

import java.util.List;

@Data
public class SkuQueryDTO {

    private String action;

    private String actionDetail;

    private String id;

    private Integer skuId;

    // 商品名称
    private String skuName;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer minStock;

    private Integer maxStock;

    private String brand;

    private String analyzer;

    private String description;

    private String field;

    private List<String> ids;
}