package org.example.aggregate.group.event;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.aggregate.group.entity.InvoiceConfigEntity;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@ToString
public class GroupEditedEvent {
    /**
     * 客户id
     */
    private Long groupId;

    /**
     * id
     */
    private Long corpId;

    /**
     * 本次修改不需要审核的字段
     */
    private Map<String, Object> needVerify;

    /**
     * 初次审核是否已经通过
     */
    private Boolean firstVerifyPassed;

    private List<InvoiceConfigEntity> invoiceConfigList;

    private Long operatorId;

    private String operatorName;
}
