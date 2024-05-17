package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgDTO {
    private Integer height;
    private Integer width;
    private Integer img_type;
    private String img_url;

    public ImgDTO() {
        this.img_url = "";
        this.height = 0;
        this.width = 0;
        this.img_type = 1;
    }
}
