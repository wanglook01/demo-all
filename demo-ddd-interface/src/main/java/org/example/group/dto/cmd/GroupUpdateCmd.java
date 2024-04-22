package org.example.group.dto.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupUpdateCmd implements Serializable {

    private Long id;

    private Integer status;


}
