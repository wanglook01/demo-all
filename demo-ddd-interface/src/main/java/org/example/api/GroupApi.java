package org.example.api;

import org.example.dto.cmd.GroupCreateCmd;
import org.example.dto.cmd.GroupDeleteCmd;
import org.example.dto.cmd.GroupUpdateCmd;

public interface GroupApi {

    Long createGroup(GroupCreateCmd createCmd);

    Long updateGroup(GroupUpdateCmd updateCmd);


    Integer deleteGroup(GroupDeleteCmd deleteCmd);


}
