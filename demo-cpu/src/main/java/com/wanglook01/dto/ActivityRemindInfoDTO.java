package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 活动提示信息
 */
@Data
public class ActivityRemindInfoDTO implements Serializable {

    private PromoteTagDTO img;

    private TagTextDTO text;

    private String msg;

    private List<Integer> promote_activity_tag;

    public static ActivityRemindInfoDTO get(){
        return new ActivityRemindInfoDTO();
    }

}
