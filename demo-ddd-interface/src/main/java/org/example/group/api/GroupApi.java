package org.example.group.api;

import org.example.common.ResponseResult;
import org.example.group.cmd.GroupCreateCmd;
import org.example.group.cmd.GroupDeleteCmd;
import org.example.group.cmd.GroupUpdateCmd;

public interface GroupApi {

    ResponseResult<Long> createGroup(GroupCreateCmd createCmd);

    ResponseResult<Long> updateGroup(GroupUpdateCmd updateCmd);


    ResponseResult<Long> deleteGroup(GroupDeleteCmd deleteCmd);




}
