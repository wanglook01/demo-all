package org.example.group.apiimpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.EventPublisher;
import org.example.aggregate.group.domainservice.GroupDomainService;
import org.example.aggregate.group.domainservice.GroupFactory;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.event.GroupCreateEvent;
import org.example.aggregate.group.repository.GroupRepository;
import org.example.common.ResponseResult;
import org.example.converter.GroupAppConverter;
import org.example.group.api.GroupApi;
import org.example.group.cmd.GroupCreateCmd;
import org.example.group.cmd.GroupDeleteCmd;
import org.example.group.cmd.GroupUpdateCmd;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class GroupApiImpl implements GroupApi {

    @Resource
    private GroupFactory groupFactory;

    @Resource
    private GroupRepository groupRepository;

    @Resource
    private EventPublisher eventPublisher;

    @Resource
    private GroupDomainService groupDomainService;

    @Resource
    private GroupAppConverter groupAppConverter;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<Long> createGroup(GroupCreateCmd createCmd) {
        GroupDO groupDO = groupFactory.create(createCmd);
        log.info("groupDO:{}", groupDO);
        Long groupId = groupRepository.save(groupDO);
        GroupCreateEvent groupCreateEvent = groupDO.getGroupCreateEvent("group-create", groupId, createCmd.getOperateId(), createCmd.getOperateName());
        eventPublisher.publish(groupCreateEvent);
        return ResponseResult.success(groupId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<Long> updateGroup(GroupUpdateCmd updateCmd) {
        GroupDO groupDO = groupRepository.get(updateCmd.getId());
        groupDomainService.update(groupDO, groupAppConverter.convert(updateCmd));
        groupRepository.save(groupDO);
        return ResponseResult.success(updateCmd.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<Long> deleteGroup(GroupDeleteCmd deleteCmd) {
        GroupDO groupDO = groupRepository.get(deleteCmd.getId());
        groupDO.delete();
        groupRepository.save(groupDO);
        return ResponseResult.success(deleteCmd.getId());
    }

}
