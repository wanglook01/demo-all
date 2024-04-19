package org.example.dto;

import lombok.Data;

@Data
public class ContractDTO {

    private Long id;

    /**
     * 客户id
     */
    private Long groupId;

    /**
     * 合同类型 1:"客户合同" 2:"三方代采协议"
     */
    private Integer contractType;

    /**
     * 合同开始时间
     */
    private Integer contractStart;

    /**
     * 合同结束时间
     */
    private Integer contractEnd;

    /**
     * 合同状态 0:待生效 1:生效中 2:预过期（还有15天过期） 3:已过期 4:已作废
     */
    private Integer contractStatus;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 导入时间
     */
    private Long importTime;

    private Long cT;

    private Long uT;

    private Integer isDeleted;
}
