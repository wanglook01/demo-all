package org.example.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 查询
     */
    @RequestMapping("/getById/{id}")
    public Object getById(@PathVariable Long id) {
        return userService.getById(id);
    }


    /**
     * 插入
     */
    @RequestMapping("/create/{name}/{status}")
    public Object create(@PathVariable String name, @PathVariable Integer status) {
        return userService.create(name, status);
    }
}
