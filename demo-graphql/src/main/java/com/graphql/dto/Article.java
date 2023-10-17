package com.graphql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Article {

    private Integer id;

    private String text;

    public Article(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}
