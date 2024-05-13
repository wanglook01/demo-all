package org.example.spring.business.transaction;

import org.example.spring.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SkuService {

    @Resource
    private UserService userService;

    @Value("${server.port}")
    private Integer port;

    @Transactional
    public String getMessage() {
        return "";
    }
}
