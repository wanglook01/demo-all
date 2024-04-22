package org.example.group.dto.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupDeleteCmd implements Serializable {

    private Long id;
}
