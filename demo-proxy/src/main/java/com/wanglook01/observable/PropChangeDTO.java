package com.wanglook01.observable;

import lombok.Data;

import java.util.List;

@Data
public class PropChangeDTO {

    private Long userId;

    private String requestUrl;

    private List<String> observablePropList;
}
