package com.wanglook01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PredictRecommendTagsDetailDTO implements Serializable {

    private Boolean is_recommend;

    private List<RecommendTag> predict_recommend_tags;

    private Object mj_activity;

    private Object coupon;

    private RecommendRuleDesc recommend_rule_desc;

    @Data
    public static class RecommendTag{
        private String threshold_tag;
        private Integer tag_type;
    }

    @Data
    public static class RecommendRuleDesc{
        private String rule_title;

        private String rule_url;
    }

}
