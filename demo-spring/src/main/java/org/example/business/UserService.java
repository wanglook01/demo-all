package org.example.business;

import org.example.business.common.UserPO;

public interface UserService {

    UserPO getById(Long id);

    Integer create(String name, Integer status);
}
