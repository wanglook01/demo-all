package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PromoteTagDTO implements Serializable {

    private Integer width;

    private Integer height;

    private String url;

    private Integer type;

    private String msg;

}
