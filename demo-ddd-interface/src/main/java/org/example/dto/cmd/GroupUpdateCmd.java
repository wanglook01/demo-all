package org.example.dto.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupUpdateCmd implements Serializable {

    private Long id;

    private Integer status;


}
