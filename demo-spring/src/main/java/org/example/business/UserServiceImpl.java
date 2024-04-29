package org.example.business;

import org.example.business.common.UserPO;
import org.example.business.mapper.UserMapper;
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
