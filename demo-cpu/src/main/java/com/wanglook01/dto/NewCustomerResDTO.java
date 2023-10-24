package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewCustomerResDTO implements Serializable {


    private Integer newCustomerType;

    private String newCustomerRemind;

    private Integer canBuyNum;


    public static NewCustomerResDTO get() {
        return new NewCustomerResDTO();
    }

}
