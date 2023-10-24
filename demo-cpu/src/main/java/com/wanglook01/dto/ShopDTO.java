package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopDTO implements Serializable {

    private Integer cooperativeMode;
    private Long id;
    private Integer isFlagship;
    private String name;
    private Integer _blank;
    private String shopShowName;

    public static ShopDTO get(){
        return new ShopDTO();
    }

}
