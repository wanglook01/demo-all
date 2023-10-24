package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AfterSaleInfoDTO implements Serializable {

    private List<String> list;

    private String dialog_title;

    private List<String> dialog_content;
}
