package com.wanglook01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class SkuTypeDTO {

    // 商品ID，唯一标识符
    private Long sku_id;

    private Long ssu_id;

    private SkuTypeInnerDTO sku_object;

    private SkuTypeInnerDTO sku_nested;

    private Map<String, Object> sku_join;

    public SkuTypeDTO(Long sku_id, Long ssu_id, SkuTypeInnerDTO sku_object, SkuTypeInnerDTO sku_nested) {
        this.sku_id = sku_id;
        this.ssu_id = ssu_id;
        this.sku_object = sku_object;
        this.sku_nested = sku_nested;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SkuTypeInnerDTO {
        private Long id;
        private String name;
        private AddressDTO address;

        public SkuTypeInnerDTO(Long id, String name, AddressDTO address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class AddressDTO {
        private String city;
        private String region;

        public AddressDTO(String city, String region) {
            this.city = city;
            this.region = region;
        }

    }
}