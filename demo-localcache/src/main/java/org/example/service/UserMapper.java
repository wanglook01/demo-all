package org.example.service;

import org.example.dto.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserMapper {

    public static Map<Long, User> map = new HashMap<>();

    static {
        map.put(1L, new User(1L, "张三"));
        map.put(2L, new User(2L, "李四"));
        map.put(3L, new User(3L, "王五"));
        map.put(4L, new User(4L, "赵六"));
        map.put(5L, new User(5L, "甲"));
        map.put(6L, new User(6L, "乙"));
        map.put(7L, new User(7L, "丙"));
        map.put(8L, new User(8L, "丁"));
        map.put(9L, new User(9L, "戊"));
    }


    public User getById(Long id) {
        return map.get(id);
    }

    public List<User> getAll() {
        return new ArrayList<>(map.values());
    }
}
