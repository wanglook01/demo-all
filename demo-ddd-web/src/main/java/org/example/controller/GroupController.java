package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.group.api.GroupApi;
import org.example.group.dto.cmd.GroupCreateCmd;
import org.example.group.dto.cmd.GroupDeleteCmd;
import org.example.group.dto.cmd.GroupUpdateCmd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/group")
public class GroupController {

    @DubboReference(retries = 0, timeout = 60000)
    private GroupApi groupApi;


    /**
     * 客户管理 /客户列表 /创建客户
     */
    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody GroupCreateCmd createCmd) {
        log.info("create:{}", createCmd);
        Long groupId = groupApi.createGroup(createCmd);
        return Collections.singletonMap("groupId", groupId);
    }

    /**
     * 修改客户状态
     */
    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody GroupUpdateCmd updateCmd) {
        log.info("updateCmd:{}", updateCmd);
        Long groupId = groupApi.updateGroup(updateCmd);
        return Collections.singletonMap("groupId", groupId);
    }


    /**
     * 删除客户
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestBody GroupDeleteCmd deleteCmd) {
        log.info("deleteCmd:{}", deleteCmd);
        Long groupId = groupApi.deleteGroup(deleteCmd);
        return Collections.singletonMap("groupId", groupId);
    }


}
