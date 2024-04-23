package org.example.group.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupPageQuery implements Serializable {

    private String name;

    private Integer pageNum;

    private Integer pageSize;
}
