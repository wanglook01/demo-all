package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TextDTO implements Serializable {
    private String text;

    private String color;

    private Integer tap_type;

    private String tap_content;

    private Integer type;
}
