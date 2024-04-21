package org.example.log.converter;

import org.example.aggregate.log.entity.OperateLogDO;
import org.example.log.po.OperateLogPO;
import org.springframework.stereotype.Service;

@Service
public class LogConverter {

    public OperateLogPO log2Po(OperateLogDO logDO) {
        OperateLogPO logPO = new OperateLogPO();
        logPO.setId(logDO.getId());
        logPO.setTargetId(logDO.getTargetId());
        logPO.setOperatorDimension(logDO.getOperatorDimension());
        logPO.setOperatorType(logDO.getOperatorType());
        logPO.setOperatorContent(logDO.getOperatorContent());
        logPO.setOperatorId(logDO.getOperatorId());
        logPO.setOperatorName(logDO.getOperatorName());
        logPO.setCT(logDO.getCT());
        logPO.setUT(logDO.getUT());
        return logPO;
    }
}
