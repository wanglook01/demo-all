package com.graphql;

import com.graphql.dto.City;
import com.graphql.dto.User;
import com.graphql.dto.UserDTO;
import graphql.com.google.common.collect.Lists;
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
        user1.setCity(City.hangzhou);
        user1.setFriends(Lists.newArrayList(new User(300, "娃哈哈", "娃娃", City.chengdu)));
        User user2 = new User();
        user2.setId(200);
        user2.setUsername("王二小");
        user2.setNickname("小王");
        user2.setCity(City.shanghai);
        user2.setFriends(Lists.newArrayList(new User(400, "李四", "小四", City.shenzhen)));
        return Arrays.asList(user1, user2);
    }

    public User getUser(Integer id) {
        return new User(id, "王五", "小五", City.shenzhen);
    }


    public List<UserDTO> getUsersAndArticles() {
        User user1 = new User(1, "读书的人1", Lists.newArrayList(1, 2, 3));
        User user2 = new User(2, "读书的人2", Lists.newArrayList(4, 5, 6));
        //转化为userDTO
        return Lists.newArrayList(new UserDTO(user1.getId(), user1.getUsername(), user1.getArticleIds()),
                new UserDTO(user2.getId(), user2.getUsername(), user2.getArticleIds()));
    }


}