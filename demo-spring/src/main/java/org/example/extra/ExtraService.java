package org.example.extra;

import org.example.spring.business.UserService;
import org.example.spring.business.common.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


public class ExtraService {

    @Resource
    private UserService userService;

    public Integer getAge() {
        UserPO byId = userService.getById(1L);
        return byId.getId();
    }
}
