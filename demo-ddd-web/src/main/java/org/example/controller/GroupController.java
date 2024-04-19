package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.api.GroupApi;
import org.example.dto.cmd.GroupCreateCmd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupApi groupApi;


    /**
     * 客户管理 /客户列表 /创建客户
     *
     * @return
     */
    @PostMapping("/create")
    public Map<String, Object> add(@RequestBody GroupCreateCmd createCmd) {
        Long groupId = groupApi.createGroup(createCmd);
        return Collections.singletonMap("groupId", groupId);
    }


}
