package org.example.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.aggregate.group.domainservice.GroupFactory;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.repository.GroupRepository;
import org.example.api.GroupApi;
import org.example.dto.cmd.GroupCreateCmd;
import org.example.dto.cmd.GroupDeleteCmd;
import org.example.dto.cmd.GroupUpdateCmd;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class GroupApiImpl implements GroupApi {

    @Resource
    private GroupFactory groupFactory;

    @Resource
    private GroupRepository groupRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createGroup(GroupCreateCmd createCmd) {
        GroupDO groupDO = groupFactory.create(createCmd);
        log.info("groupDO:{}", groupDO);
        return groupRepository.save(groupDO);
    }

    @Override
    public Long updateGroup(GroupUpdateCmd updateCmd) {
        GroupDO groupDO = groupRepository.get(updateCmd.getId());
        groupDO.updateStatus(updateCmd.getStatus());
        return groupRepository.save(groupDO);
    }

    @Override
    public Integer deleteGroup(GroupDeleteCmd deleteCmd) {
        return null;
    }
}
