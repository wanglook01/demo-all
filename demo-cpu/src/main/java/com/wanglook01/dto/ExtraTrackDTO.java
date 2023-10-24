package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wanglook01.util.RandomUtil;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraTrackDTO {

    private String goodsSsuList;

    private String mall_tag_type = "";

    public static ExtraTrackDTO get() {
        ExtraTrackDTO dto = new ExtraTrackDTO();
        dto.setGoodsSsuList(RandomUtil.randomStr(10));
        dto.setMall_tag_type(RandomUtil.randomStr(5));
        return dto;
    }
}
