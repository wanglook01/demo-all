package org.example.spring.business;

import org.example.spring.business.common.UserPO;

public interface UserService {

    UserPO getById(Long id);

    Integer create(String name, Integer status);
}
