package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.common.ResponseResult;
import org.example.group.api.GroupApi;
import org.example.group.api.GroupQueryApi;
import org.example.group.cmd.GroupCreateCmd;
import org.example.group.cmd.GroupUpdateCmd;
import org.example.group.query.GroupPageQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/group")
public class GroupController {

    @DubboReference(retries = 0, timeout = 60000)
    private GroupApi groupApi;

    @DubboReference(retries = 0, timeout = 60000)
    private GroupQueryApi groupQueryApi;

    /**
     * 创建客户
     */
    @PostMapping("/create")
    public ResponseResult<?> create(@RequestBody GroupCreateCmd createCmd) {
        try {
            log.info("create:{}", createCmd);
            return groupApi.createGroup(createCmd);
        } catch (Exception e) {
            log.error("create,error", e);
            return ResponseResult.failure(e.getMessage());
        }
    }

    /**
     * 修改客户信息
     */
    @PostMapping("/update")
    public ResponseResult<?> update(@RequestBody GroupUpdateCmd updateCmd) {
        try {
            log.info("updateCmd:{}", updateCmd);
            return groupApi.updateGroup(updateCmd);
        } catch (Exception e) {
            log.error("update,error", e);
            return ResponseResult.failure(e.getMessage());
        }
    }


    /**
     * 删除客户
     */
    @PostMapping("/getPage")
    public ResponseResult<?> getPage(@RequestBody GroupPageQuery groupPageQuery) {
        try {
            log.info("groupPageQuery:{}", groupPageQuery);
            return groupQueryApi.getPage(groupPageQuery);
        } catch (Exception e) {
            log.error("getPage,error", e);
            return ResponseResult.failure(e.getMessage());
        }
    }


}
