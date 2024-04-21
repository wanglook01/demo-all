package org.example.aggregate.log.domainservice;

import org.example.aggregate.log.entity.OperateLogDO;

public interface OperateLogFactory {

    OperateLogDO create(Object input);
}
