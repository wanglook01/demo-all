package org.example.aggregate.group.entity;

import lombok.Data;
import org.example.aggregate.group.command.GroupEditCommand;
import org.example.aggregate.group.event.GroupCreateEvent;

import java.math.BigDecimal;
import java.util.List;

/**
 * 客户，实体，有id
 * 另外还有一些值对象，一对多，一对一
 * 这个是一个实体，同时是一个聚合根
 */
@Data
public class GroupDO {


    private Long id;

    /**
     * 企业名称
     */
    private String name;


    private Integer status;

    //地址信息
    private AddressValObj addressValObj;

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

    private Long cT;

    private Long uT;

    private Integer isDeleted;


    /**
     * 合同信息
     */
    private List<ContractEntity> contractList;


    /**
     * 发票信息
     */
    private List<InvoiceConfigEntity> invoiceConfigList;


    public void update(GroupEditCommand command) {
        this.name = command.getName();
        this.phone = command.getPhone();
        this.uT = System.currentTimeMillis() / 1000;
    }


    public void delete() {
        this.isDeleted = 1;
        this.uT = System.currentTimeMillis() / 1000;
        for (ContractEntity contractEntity : this.contractList) {
            contractEntity.setIsDeleted(1);
            contractEntity.setUT(this.uT);
        }
        for (InvoiceConfigEntity invoiceConfigEntity : this.invoiceConfigList) {
            invoiceConfigEntity.setIsDeleted(1);
            invoiceConfigEntity.setUT(this.uT);
        }
    }

    public GroupCreateEvent getGroupCreateEvent(String topic, Long id, Long operateId, String operateName) {
        GroupCreateEvent event = new GroupCreateEvent();
        event.setTopic(topic);
        event.setGroupId(id);
        event.setOperatorContent("创建用户成功");
        event.setOperatorType(1);
        event.setOperatorDimension(1);
        event.setOperatorId(operateId);
        event.setOperatorName(operateName);
        return event;
    }


}
