package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class PredictPriceTextDTO implements Serializable {

    private String predictTypeMsgPrefix;

    private String priceSymbol;

    private String predictShowPrice;

    private String predictPriceUnitSuffix;

    public static PredictPriceTextDTO get(){
        return new PredictPriceTextDTO();
    }

}
