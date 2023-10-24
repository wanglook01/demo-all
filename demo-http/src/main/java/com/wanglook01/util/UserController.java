package com.wanglook01.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-http")
public class UserController {

    @RequestMapping("/demo")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("helloWorld");
        user.setAddress("china");
        return user;
    }
}
