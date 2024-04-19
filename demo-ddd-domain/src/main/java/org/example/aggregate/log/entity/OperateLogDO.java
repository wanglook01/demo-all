package org.example.aggregate.log.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 门店操作日志，也作为一个do，在同一个聚合内
 * 之所以不作为值对象，是因为不需要每次都查询，且做更新
 */
@Data
public class OperateLogDO implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 客户id/门店id
     */
    private Long targetId;

    /**
     * 操作维度 1：客户 2：门店 3...
     */
    private Integer operatorDimension;

    /**
     * 操作类型 1：启用操作 2：停用操作  3：删除操作
     */
    private Integer operatorType;

    /**
     * 操作内容
     */
    private String operatorContent;

    /**
     * 操作人uid
     */
    private Integer operatorId;

    /**
     * 操作人名称
     */
    private String operatorName;

    /**
     * 创建时间
     */
    private Long cT;

    /**
     * 修改时间
     */
    private Long uT;
}
