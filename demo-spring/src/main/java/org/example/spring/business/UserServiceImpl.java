package org.example.spring.business;

import org.example.spring.business.common.UserPO;
import org.example.spring.business.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserPO getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer create(String name, Integer status) {
        UserPO userPO = new UserPO();
        userPO.setName(name);
        userPO.setStatus(status);
        return userMapper.insert(userPO);
    }
}
