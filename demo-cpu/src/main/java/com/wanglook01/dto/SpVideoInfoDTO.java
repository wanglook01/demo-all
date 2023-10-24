package com.wanglook01.dto;

import com.wanglook01.util.RandomUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpVideoInfoDTO implements Serializable {

    private String videoUrl;

    private String videoDesc;

    private String videoPackage;

    private String videoGif;

    private Long uploadTime;

    public static SpVideoInfoDTO get() {
        SpVideoInfoDTO dto = new SpVideoInfoDTO();
        dto.setVideoUrl(RandomUtil.randomStr(20));
        dto.setVideoDesc(RandomUtil.randomStr(20));
        dto.setVideoPackage(RandomUtil.randomStr(20));
        dto.setVideoGif(RandomUtil.randomStr(20));
        dto.setUploadTime(RandomUtil.randomLong());
        return dto;
    }
}
