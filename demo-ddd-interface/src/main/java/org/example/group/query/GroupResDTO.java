package org.example.group.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupResDTO implements Serializable {

    private Long id;

    /**
     * 企业名称
     */
    private String name;


    private Integer status;

    /**
     * 联系人姓名
     */
    private String personName;

    /**
     * 移动电话
     */
    private String phone;

    /**
     * 维护销售id
     */
    private String saleCode;
}
