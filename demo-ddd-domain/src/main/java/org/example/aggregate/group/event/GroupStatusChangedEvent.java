package org.example.aggregate.group.event;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class GroupStatusChangedEvent {

    /**
     * 客户id
     */
    private Long groupId;

    /**
     * 客户name
     */
    private String groupName;

    /**
     * id
     */
    private Long corpId;

    private String phone;

    /**
     * 新的状态
     */
    private Integer newStatus;


    private Long operatorId;

    private String operatorName;
}
