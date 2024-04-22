package org.example.group.api;

import org.example.group.dto.cmd.GroupCreateCmd;
import org.example.group.dto.cmd.GroupDeleteCmd;
import org.example.group.dto.cmd.GroupUpdateCmd;

public interface GroupApi {

    Long createGroup(GroupCreateCmd createCmd);

    Long updateGroup(GroupUpdateCmd updateCmd);


    Long deleteGroup(GroupDeleteCmd deleteCmd);


}
