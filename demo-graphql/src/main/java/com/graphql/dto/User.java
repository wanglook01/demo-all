package com.graphql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String nickname;

    private City city;

    private List<User> friends;

    private List<Integer> articleIds;

    public User(Integer id, String username, String nickname, City city) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.city = city;
    }

    public User(Integer id, String username, List<Integer> articleIds) {
        this.id = id;
        this.username = username;
        this.articleIds = articleIds;
    }
}
