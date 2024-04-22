package org.example.assembler;

import org.example.aggregate.group.command.GroupEditCommand;
import org.example.group.dto.cmd.GroupUpdateCmd;
import org.springframework.stereotype.Service;

@Service
public class GroupAppConverter {

    public GroupEditCommand convert(GroupUpdateCmd cmd) {
        GroupEditCommand command = new GroupEditCommand();
        command.setName(cmd.getName());
        command.setPhone(cmd.getPhone());
        return command;
    }
}
