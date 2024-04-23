package org.example.group.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupDeleteCmd implements Serializable {

    private Long id;
}
