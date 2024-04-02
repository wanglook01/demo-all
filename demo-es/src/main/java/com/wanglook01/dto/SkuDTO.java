package com.wanglook01.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuDTO {

    // 商品ID，唯一标识符
    private Long skuId;

    // 商品名称
    private String skuName;

    // 商品类别，例如“蔬菜”、“禽蛋”
    private ClassInfoDTO classInfo;

    // 商品品牌（可选，对某些商品可能重要，如品牌鸡蛋）
    private String brand;

    // 商品主图URL
    private List<String> images;

    // 商品单价，使用BigDecimal处理货币精度问题
    private BigDecimal price;

    // 商品重量，单位可根据实际情况设定（克、千克等）
    private WeightDTO weight;

    // 商品库存数量
    private int stock;

    private Integer status;

    // 商品产地
    private OriginDTO origin;

    // 商品描述
    private String description;

    // 生产日期（可选，对于食品类商品有意义）
    private Integer productionDate;

    // 有效期或保质期（可选，食品类商品通常需要）
    private Integer expirationPeriod;

    // 是否为有机产品（布尔类型，标记是否为有机西红柿或有机鸡蛋等）
    private Boolean organic;


    @Getter
    @Setter
    @NoArgsConstructor
    public static class WeightDTO {
        private Double value;
        private String unit;

        public WeightDTO(Double value, String unit) {
            this.value = value;
            this.unit = unit;
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class OriginDTO {
        private String name;
        private String region;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ClassInfoDTO {
        private Integer class1Id;
        private Integer class2Id;
        private Integer class3Id;

    }
}