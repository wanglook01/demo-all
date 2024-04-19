package org.example.group.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 和数据库是一一对应的
 */
@Data
@TableName("t_group")
public class GroupPO {


    @TableId
    private Long id;

    /**
     * 企业名称
     */
    private String name;

    private Integer status;

    //地址信息
    private Integer provinceId;

    private Integer cityId;

    private String addressDetail;

    /**
     * 联系人姓名
     */
    private String personName;


    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 维护销售id
     */
    private String saleCode;

    /**
     * 客户标签
     */
    private Integer label;

    /**
     * 支付方式。1：货到付款，2：在线支付，3：账期，4：预付款
     */
    private Integer payWay;

    /**
     * 账期天数
     */
    private Integer dayCount;


    /**
     * 日均预采购额
     */
    private BigDecimal estimateOrderAmount;

    /**
     * 结算周期类型,1:按天,2:按月,3:按半月
     */
    private Integer settleCycleType;

    /**
     * 开票周期天数
     */
    private Integer invoiceCycleDays;

    /**
     * 回款周期天数
     */
    private Integer backMoneyCycleDays;


    /**
     * 短信通知接收人, 可以是多个
     */
    private String receiveSmsPhone;

    /**
     * 是否支持冷链,0否,1是
     */
    private Integer supportColdChain;


    /**
     * passport_id
     */
    private Long passportId;


    @TableField("c_t")
    private Long cT;

    @TableField("u_t")
    private Long uT;

    @TableField("is_deleted")
    private Integer isDeleted;
}
