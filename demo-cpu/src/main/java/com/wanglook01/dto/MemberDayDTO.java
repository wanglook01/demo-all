package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberDayDTO implements Serializable {

    private Integer show;
    private String text;
    private String app_link;
    private String h5_link;

    public static MemberDayDTO get(){
        return new MemberDayDTO();
    }

}
