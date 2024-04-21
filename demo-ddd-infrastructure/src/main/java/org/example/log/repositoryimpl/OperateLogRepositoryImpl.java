package org.example.log.repositoryimpl;

import org.example.aggregate.log.entity.OperateLogDO;
import org.example.aggregate.log.repository.OperateLogRepository;
import org.example.log.converter.LogConverter;
import org.example.log.mapper.OperateLogMapper;
import org.example.log.po.OperateLogPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OperateLogRepositoryImpl implements OperateLogRepository {

    @Resource
    private LogConverter logConverter;

    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public OperateLogDO get(Long aLong) {
        return null;
    }

    @Override
    public Long save(OperateLogDO entity) {
        OperateLogPO logPO = logConverter.log2Po(entity);
        operateLogMapper.insert(logPO);
        return logPO.getId();
    }
}
