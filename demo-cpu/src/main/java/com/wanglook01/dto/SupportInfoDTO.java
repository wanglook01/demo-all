package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportInfoDTO implements Serializable {

    private String title;

    private String img_url;

    private Integer type;

    private Object content;

    private List<String> marks;

    private List<List<RuleContent>> rules;

    public static SupportInfoDTO get(){
        return new SupportInfoDTO();
    }

    @Data
    public static class RuleContent {
        private String color;

        private String content;

    }

}
