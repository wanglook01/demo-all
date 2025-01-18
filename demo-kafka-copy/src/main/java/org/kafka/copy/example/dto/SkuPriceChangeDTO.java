package org.kafka.copy.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuPriceChangeDTO {

    private Long skuId;

    private BigDecimal fromPrice;

    private BigDecimal toPrice;

}
