package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * pageData
 */
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageDataResDTO implements Serializable {

    private String id;

    private List<DataBeanX> data;

    private Style style;
    private String code;
    private String type;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataBeanX {

        private String params;
        private String data_source;

        private Map<String, Object> tickerInfo;
    }


    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Style {
        private Integer scrollerPosition;
        private Integer ps;
        private Integer pt;
        private Integer ms;
        private Integer mt;
        private String ir;
        private Integer is;
        private ImgDTO bgImg;
        private ImgDTO titleBgImg;

        //今日特卖
        private ImgDTO bgImg1;
        private ImgDTO bgImg2;
        private ImgDTO bgImg3;
        //今日特卖

        private String type;
        private ImgDTO zzImg;
        private ImgDTO attachImg1;
        private Integer br;
        private Integer pb;
        private Integer mb;
        private String name;

        //阶段运营
        private String bgColorStart;
        private String bgColorEnd;
        private String bgType1;

        //首页秒杀
        private Map<String, Object> other;

        //金刚区
        private String cornerFontColor;
        private String cornerBgColor;
        private String textColor;
        private Integer maxLine;
        private String iconType;
        private String showMore;
        private String shadowColor;
        private Integer lineCount;

        //商品组件
        private String goodsLayout;

        //锚点
        private String selectTextColor;
        private String selectedColor;
        private String bgType2;

        //分类tab
        private String unselectTitleColor;
        private String subTitleBgColor;
        private String selectedTitleColor;
        private String unselectSubTitleColor;
        private String selectedSubTitleColor;

        //飘窗
        private String floatWindowType;

        //抽奖
        private String lotteryType;
        private ImgDTO buttonImg;
        private ImgDTO gridImg;

        private String lotteryListType;

        private String popupType;//弹窗
        private String scrollerType;//轮播
        private String mcSeckillType;//秒杀

        //新人活动位边框颜色
        private String borderColor;
        private String borderColor2;

        //标题颜色
        private String titleColor;

        //标题类型
        private String titleType;

        private String titleType_2n;

        private ImgDTO bgImg1_2n;
        private ImgDTO bgImg2_2n;
        private ImgDTO bgImg3_2n;

        private Integer ps_2n;
        private Integer pt_2n;
        private Integer ms_2n;
        private Integer mt_2n;
        private Integer br_2n;
        private Integer pb_2n;
        private ImgDTO attachImg1_2n;

        /**
         * 金刚位图标大小
         */
        private Integer iconSize;
    }
}
