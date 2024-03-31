package com.wanglook01.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductQueryDTO {

    private String action;

    private String id;

    private Integer skuId;

    // 商品名称
    private String skuName;

    private Integer minPrice;

    private Integer maxPrice;

    private String brand;
}