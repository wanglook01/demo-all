package org.example.event;

import org.example.aggregate.group.event.GroupCreateEvent;
import org.example.aggregate.log.domainservice.OperateLogFactory;
import org.example.aggregate.log.entity.OperateLogDO;
import org.example.aggregate.log.repository.OperateLogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 自动注入，这里因为没有部署rocketmq，所以写了一个初始化脚本
 */
@Service
public class GroupCreateEventListener implements EventListener<GroupCreateEvent> {

    @Resource
    private OperateLogFactory operateLogFactory;

    @Resource
    private OperateLogRepository operateLogRepository;


    @Override
    public void handle(GroupCreateEvent groupCreateEvent) {
        OperateLogDO operateLogDO = operateLogFactory.create(groupCreateEvent);
        operateLogRepository.save(operateLogDO);
    }

    @PostConstruct
    public void init() {
        GroupCreateEvent event = new GroupCreateEvent();
        event.setTopic("group-create");
        event.setGroupId(11223344L);
        event.setOperatorContent("创建用户成功");
        event.setOperatorType(1);
        event.setOperatorDimension(1);
        event.setOperatorId(123L);
        event.setOperatorName("operateName");
        this.handle(event);
    }

}
