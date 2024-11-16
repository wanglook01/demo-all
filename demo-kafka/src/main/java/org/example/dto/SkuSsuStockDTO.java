package org.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuSsuStockDTO {

    private String skuId;

    private String ssuId;

    private Integer stock;

    private BigDecimal price;

}
