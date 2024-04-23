package org.example.group.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupUpdateCmd implements Serializable {

    private Long id;

    private String name;

    private String phone;


}
