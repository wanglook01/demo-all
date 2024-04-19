package org.example.aggregate.group.entity;

import lombok.Data;

/**
 * 发票信息，值对象
 */
@Data
public class InvoiceConfigEntity {

    private Long id;

    private Long groupId;

    /**
     * 一级售卖分类id
     */
    private Integer saleClassOneId;

    /**
     * 一级售卖分类名称
     */
    private String saleClassOneName;

    /**
     * 发票种类 1 专票 2 普票
     */
    private Integer invoiceType;

    /**
     * 是否接受零税点 1 接受 2 不接受
     */
    private Integer acceptZeroTax;

    private Long cT;

    private Long uT;

    private Integer isDeleted;
}