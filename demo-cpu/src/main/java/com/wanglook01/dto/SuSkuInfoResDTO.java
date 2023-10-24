package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wanglook01.dto.TagTextDTO;
import com.wanglook01.util.RandomUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuSkuInfoResDTO implements Serializable {

    private Long sku_id;

    private String name;

    private String alias_name;

    private String img_url;

    private String sku_unit;

    private String min_price;

    private String max_price;

    private String unique_id;

    private Integer sale_c1_id;

    private Integer sale_c2_id;

    private List<Integer> saleC1Ids;

    private List<Integer> saleC2Ids;

    private Integer is_non_halal;

    private Long bi_id;

    private String bi_name;

    private Integer sku_sale_to_c;

    private String sku_format;

    private List<String> core_label;

    private List<TagTextDTO> core_label_list;

    private Integer delivery_way;

    private Integer sku_unit_size;

    private List<SkuCoreAttrDTO> core_attrs;

    private Object temperature;

    private List<TagTextDTO> attributeList;

    private List<TagResDTO> goodsTagList;

    private Integer is_predict_price;

    private Integer spu_id;

    private String spu_name;

    private Integer pspuId;

    private String predict_min_unit_price;

    private String predict_max_unit_price;

    private String max_weight_price;

    private String min_weight_price;

    private List<SuSkuInfoResDTO> ssu_list;

    private List<TagTextDTO> purchaseLabelList;

    private Long ssu_id;

    private Integer ssu_fp;

    private String tag;

    private List<TagTextDTO> tags_list;

    private String price_unit;

    private Integer sku_physical_count;

    private Integer sell_type;

    private Integer ssi_time_limit_type;

    private String ssi_st_str;

    private String ssi_et_str;

    private Integer p_package_deposit;

    private Integer is_received;

    private Long pop_id;

    private String pop_name;

    private String pop_short_name;

    private Integer pop_rec_buy;

    private String sku_name;

    private Map<String, AttrInfoDTO> attr_list;

    private List<String> lucency_pics;

    private String ssb_desc;

    private Integer is_online;

    private Integer is_merchant_price;

    private String sell_brand;

    private Double compensate_ratio;

    private Integer delivery_date_type;

    private Integer effect_start_date;

    private Integer effect_end_date;

    private Long delivery_start_date;

    private Long delivery_end_date;

    private Integer delivery_delay_start;

    private Integer delivery_delay_end;

    private Integer tags_type;

    private List<String> goods_labels;

    private String total_format;

    private Integer pop_type;

    private List<Integer> promote_type;

    private String big_activity_id;

    private Long activity_id;

    private Long suit_activity_id;

    private String promote_st_str;

    private String promote_et_str;

    private Integer promote_can_buy_num;

    private List<Integer> promote_activity_tag;

    private ActivityRemindInfoDTO purchase_price_remind_info;

    private List<CouponDTO> coupon_list;

    private Integer stock_num;

    private Integer available_amount;

    private Long expect_arrived_time;

    private String expect_arrived_remind;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusRemindInfoDTO status_remind_info;

    private Integer is_show_weight_unit_price;

    private String weight_unit_price;

    private String weight_original_unit_price;

    private String weight_price_unit;

    private Integer price_type;

    private String package_price;

    private String unit_price;

    private String total_price;

    private String total_price_with_fp;

    private String total_price_include_package;

    private String original_unit_price;

    private String original_price;

    private String original_price_include_package;

    private Integer goods_status;

    private Integer status;

    private Integer sortStatus;

    private List<ProdActivityDTO> suits_ssu_list;

    private Integer activity_type;

    private Integer deposit_rejected_days;

    private Integer sku_package_num;

    private Integer limit_buy_num;

    private String sbu_name;

    private Integer display_minunit_price;

    private String ssu_format;

    private List<ActivityInfo> activity_list;

    private Integer format_type;

    private Integer total_goods_num;

    private List<DisplayTagDTO> display_tags;

    private Integer is_member_price;

    private String member_price;

    private String member_total_price;

    private String weight_member_price;

    private MemberDayDTO member_day;

    private ShopDTO store_info;

    private String ssu_fp_text;

    private String physical_unit;

    private String sku_ssu_format;

    private String predict_unit_price;

    private String predict_total_price;

    private Integer predict_price_type;

    private String predictPriceTypePrefixText;

    private Integer new_over_time;

    private PromotionRemindInfo promotion_remind_info;

    private String ssb_pic;

    private String level;

    private String pop_url;

    private Integer show_more_type;

    private String package_price_msg;

    private String preposition_deposit_msg;

    private String deposit_info;

    private Integer is_reward_goods;

    private String reward_desc;

    private LockInfo lock_info;

    private String promote_tag;

    private String promote_tag_name;

    private List promote_gifts;

    private List<String> promote_tag_pics;

    private List promote_type_arr;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PromoteInfo promote_info;

    private Integer use_225_style;

    private Integer use_226_style;

    private Integer is_replace;

    private Map<String, Object> spm;

    private List<Long> extension_ids;

    private List<ActivityInfo> promote;

    private Integer is_alone_sale;

    private String appointment_day;

    private Integer has_package;

    private Integer rejected_way;

    private Integer rejected_time;

    private Integer pay_way;

    private Integer sale_limit_amount;

    private String object_type;

    private Integer recommend_type;

    private List<TagTextDTO> recommend_tags;

    private String discount_price;

    private TagTextDTO title_tag_list;

    private List<TagTextDTO> title_tags_list;

    private String is_core_product;

    private String core_product_type;

    private String format_info;
    private BigDecimal promote_price;

    private Integer group_id;
    private String ad_info_id;
    private String ad_position;
    private String ad_tag;

    private String promise_code;

    private ReplaceInfo replace_info;

    private Integer sale_class1_id;

    private Integer sale_class2_id;

    private List<TagTextDTO> pop_tags;

    private PredictPriceTextDTO predict_ssu_unit_price_text;

    private PredictPriceTextDTO predict_detail_price_text;

    private PredictPriceTextDTO predict_sku_unit_price_text;

    private Map<String, Object> tickerInfo;

    private Object sku_all_format;

    private Integer price_shield;

    private String shield_text;

    private Map<String, Object> spm_info;

    private Integer is_effective;

    private Object package_price_str;

    private Integer timestamp;

    private Integer is_most_buy;

    private Integer is_minimum_price;

    private Integer is_explosive_goods;

    private String purchaseOtherProductText;

    private String mj_notice;

    private SsuCouponInfo coupon_info;

    private Map<String, Object> vip_remind_info;

    private TagTextDTO reward_goods_tag;

    private NewCustomerResDTO newCustomer;

    private List<SupportInfoDTO> service_support;

    private AfterSaleInfoDTO aftersale_info;

    private AfterSaleBannerInfo aftersale_banner;

    private List<String> extra_img;

    private DeliveryInfoDTO delivery_info;

    private Object sale_volume;

    private Long weight_price;

    private String weight_unit_name;

    private String tag_unit;

    private Boolean set_bottom;

    private Integer sku_stock_num;

    private String configure_attributes;

    private List<String> labels;

    private Boolean is_gray_unit_price;

    private String delivery_text;

    private Integer is_hint;

    private Boolean isPerformanceTag;

    private String jump_url;

    private Integer get_exposed_ssu_count;

    private String ssu_more_text;

    private BigDecimal ssu_min_price;

    private List replace_goods_list;

    private Integer is_attention;

    private String quality_score;

    private Integer is_video;

    private TagTextDTO quality_score_label;

    private String recommendSource;

    @JsonInclude
    private GoodsRankInfoDTO goodsRankInfo;

    private String feedTopTagText;

    private Integer ad_type;

    private Integer ad_pos;

    private Integer invoiceAbsentNotice;

    private String opportunityValue;

    private TagTextDTO top_volume_tag;

    private ExtraTrackDTO extraTrack;

    private Integer deliveryTextFlag;

    private String priceSpm;

    private RelationInfo relationInfo;

    private transient List<DisplayTagDTO> tagFlagList;

    private List<DisplayTagDTO> goodsTags;

    private Integer pClass1Id;

    private Integer pClass2Id;

    private Integer pClass3Id;

    private Integer videoFlag;

    private SpVideoInfoDTO spVideoInfo;

    private Integer hasQualification;

    private String skuGradeName;

    private String diffPrice;

    private Integer isIncludeWeightPrice;

    private String weightIncludePriceUnit;

    private String weightIncludeUnitPrice;

    private Integer weightIsExact;

    private String predictWeightUnitPrice;

    private Integer predictWeightIsExact;

    private String minPredictWeightUnitPrice;

    private String minWeightIncludeUnitPrice;

    private String maxWeightIncludeUnitPrice;

    private ComparePriceDTO comparePrice;

    private String newCustomerSpecialsTag;

    private Integer promotePriceTagType;

    private String promotePriceTagImg;

    private String ssuFormatMinUnit;

    private Integer buyFrequency;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PromotionRemindInfo {
        private List<Integer> promote_type;

        private Integer promotion_goods_num;

        private String over_promotion_remind;

        private String contain_normal_goods_remind;

        private List<PromoteTagDTO> promote_type_arr;

        private List<TagTextDTO> tags_list;

        private TagTextDTO search_recommend_tags_list;

        private List<Map<String, Object>> save_money_tag;

        private Integer available_amount;

        public static PromotionRemindInfo get(){
            PromotionRemindInfo promotionRemindInfo = new PromotionRemindInfo();
            promotionRemindInfo.setPromote_type(new ArrayList<>());
            promotionRemindInfo.setPromotion_goods_num(0);
            promotionRemindInfo.setOver_promotion_remind("");
            promotionRemindInfo.setContain_normal_goods_remind("");
            promotionRemindInfo.setPromote_type_arr(new ArrayList<>());
            promotionRemindInfo.setTags_list(new ArrayList<>());
            promotionRemindInfo.setSearch_recommend_tags_list(new TagTextDTO());
            promotionRemindInfo.setSave_money_tag(new ArrayList<>());
            promotionRemindInfo.setAvailable_amount(0);
            return promotionRemindInfo;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class LockInfo {

        private Integer is_lock;

        private String price;

        private Long ssu_id;

        private String unit;

        private Integer activity_type;

        private Long activity_id;

        private String text;

        private String img_url;

        private Integer is_show;

        private List<TextDTO> remind_compensate_ratio;

        public static LockInfo get(){
            LockInfo lockInfo = new LockInfo();
            lockInfo.setIs_lock(0);
            lockInfo.setPrice("");
            lockInfo.setSsu_id(0L);
            lockInfo.setUnit("");
            lockInfo.setActivity_type(0);
            lockInfo.setActivity_id(0L);
            lockInfo.setText("");
            lockInfo.setImg_url("");
            lockInfo.setIs_show(0);
            lockInfo.setRemind_compensate_ratio(new ArrayList<>());
            return lockInfo;
        }

    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PromoteInfo {
        private String promote_st_str;
        private String promote_et_str;
        public static PromoteInfo get(){
            return new PromoteInfo();
        }
    }

    @Data
    public static class ReplaceInfo {
        private Integer is_replace;
        private Long replace_sku_id;
        private String replace_remind;
        private String sku_name;
        private String recommend_remind;

        public static ReplaceInfo get(){
            return new ReplaceInfo();
        }
    }

    @Data
    public static class TagsList {
        private String tag;
        private Integer tagType;
    }

    @Data
    public static class SsuCouponInfo {
        private List<PackageCouponInfoDTO> coupon_list;

        private TagTextDTO tags_list;

        public static SsuCouponInfo get(){
            return new SsuCouponInfo();
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AfterSaleBannerInfo {

        private List<String> text;

        private String img;

        private String url;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AppointInfoDTO {
        private Integer _blank;
    }

    @Data
    public static class RelationInfo {
        private String text;
        private String target;
        private String targetStyle = "imgUrl";

        public static RelationInfo get() {
            RelationInfo info = new RelationInfo();
            info.setText(RandomUtil.randomStr(10));
            info.setTarget(RandomUtil.randomStr(15));
            return info;
        }
    }

}

