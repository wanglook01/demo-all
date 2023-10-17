package com.graphql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String username;

    private List<Integer> articleIds;

    private List<Article> articles;

    public UserDTO(Integer id, String username, List<Integer> articleIds) {
        this.id = id;
        this.username = username;
        this.articleIds = articleIds;
    }
}
