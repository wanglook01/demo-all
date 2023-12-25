package com.wanglook01.dto;

import lombok.Data;

@Data
public class D3Data {
    /**
     * 期数
     */
    private Integer code;
    /**
     * 日期，20221203
     */
    private Integer date;
    /**
     * 周几，一二三四五六日
     */
    private String week;
    /**
     * 号码，1,2,3，逗号分隔
     */
    private String red;
    /**
     * 百分位
     */
    private Integer num1;
    /**
     * 十分位
     */
    private Integer num2;
    /**
     * 个位
     */
    private Integer num3;
    /**
     * 售卖金额
     */
    private Long sales;

}
