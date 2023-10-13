package com.graphql;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String nickname;

    private City city;


    public enum City {
        hangzhou,
        shanghai
    }
}
