package org.example.log.domainserviceimpl;

import org.example.aggregate.group.event.GroupCreateEvent;
import org.example.aggregate.log.domainservice.OperateLogFactory;
import org.example.aggregate.log.entity.OperateLogDO;
import org.springframework.stereotype.Service;

@Service
public class OperateLogFactoryImpl implements OperateLogFactory {

    @Override
    public OperateLogDO create(Object input) {
        if (input instanceof GroupCreateEvent) {
            GroupCreateEvent createEvent = (GroupCreateEvent) input;
            OperateLogDO logDO = new OperateLogDO();
            logDO.setId(null);
            logDO.setTargetId(createEvent.getGroupId());
            logDO.setOperatorDimension(1);
            logDO.setOperatorType(1);
            logDO.setOperatorContent("创建客户成功");
            logDO.setOperatorId(createEvent.getOperatorId());
            logDO.setOperatorName(createEvent.getOperatorName());
            logDO.setCT(System.currentTimeMillis() / 1000);
            logDO.setUT(System.currentTimeMillis() / 1000);
            return logDO;
        }
        return null;
    }
}
