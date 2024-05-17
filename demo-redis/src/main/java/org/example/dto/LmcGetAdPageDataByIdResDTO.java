package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 获取布局系统页面布局数据Res
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LmcGetAdPageDataByIdResDTO implements Serializable {

    private String page_id;
    private String page_name;
    private String bg_end_color;
    private String bg_start_color;
    private ImgDTO bg_img;
    private Integer is_share;
    private String share_name;
    private String share_img;
    private String share_url;
    private String share_desc;
    private Integer pb;
    private List<PageDataResDTO> page_data;
}