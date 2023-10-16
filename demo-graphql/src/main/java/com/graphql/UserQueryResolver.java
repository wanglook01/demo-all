package com.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    public List<User> userList() {
        User user1 = new User();
        user1.setId(100);
        user1.setUsername("白小小");
        user1.setNickname("小白");
        user1.setCity(User.City.hangzhou);

        User user2 = new User();
        user2.setId(200);
        user2.setUsername("王二小");
        user2.setNickname("小王");
        user2.setCity(User.City.shanghai);
        return Arrays.asList(user1, user2);
    }

    public String hello() {
        return "hello";
    }


}