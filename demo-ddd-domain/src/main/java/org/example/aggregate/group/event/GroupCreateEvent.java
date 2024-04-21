package org.example.aggregate.group.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.MiEvent;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GroupCreateEvent extends MiEvent {
    /**
     * 客户id
     */
    private Long groupId;

    /**
     * 操作内容
     */
    private String operatorContent;

    /**
     * 操作维度 1：客户 2：门店 3...
     */
    private Integer operatorDimension;

    /**
     * 操作类型 1：启用操作 2：停用操作  3：删除操作
     */
    private Integer operatorType;



    private Long operatorId;

    private String operatorName;
}
