package org.example.aggregate.group.domainservice;

import org.example.adaptor.PassportGateway;
import org.example.aggregate.group.command.GroupEditCommand;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.repository.GroupRepository;

public class GroupDomainService {

    private final GroupRepository groupRepository;
    private final PassportGateway passportGateway;

    public GroupDomainService(GroupRepository groupRepository, PassportGateway passportGateway) {
        this.groupRepository = groupRepository;
        this.passportGateway = passportGateway;
    }

    public void update(GroupDO groupDO, GroupEditCommand command) {
        //如果客户名称修改，根据客户名称查找唯一性
        if (!groupDO.getName().equals(command.getName())) {
            Integer count = groupRepository.count(command.getName());
            if (count > 1) {
                throw new RuntimeException("当前客户名称已存在");
            }
        }
        //校验手机号是否在使用中
        if (!groupDO.getPhone().equals(command.getPhone())) {
            Boolean bool = passportGateway.checkPhoneIsUsed(command.getPhone());
            if (bool) {
                throw new RuntimeException("手机号在使用中");
            }
        }
        groupDO.update(command);
    }

}
