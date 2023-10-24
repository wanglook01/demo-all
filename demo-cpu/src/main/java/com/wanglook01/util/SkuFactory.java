package com.wanglook01.util;

import com.google.common.collect.Lists;
import com.wanglook01.dto.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;

public class SkuFactory {

    public static SuSkuInfoResDTO generateOneSkuWith2Ssu() {
        SuSkuInfoResDTO sku = generateOneSkuOrSsu();
        SuSkuInfoResDTO ssu1 = generateOneSkuOrSsu();
        SuSkuInfoResDTO ssu2 = generateOneSkuOrSsu();
        sku.setSsu_list(Lists.newArrayList(ssu1, ssu2));
        return sku;
    }

    private static SuSkuInfoResDTO generateOneSkuOrSsu() {
        SuSkuInfoResDTO sku = new SuSkuInfoResDTO();
        sku.setSku_id(RandomUtil.randomLong());
        sku.setName(RandomUtil.randomStr(5));
        sku.setAlias_name(RandomUtil.randomStr(5));
        sku.setImg_url(RandomUtil.randomStr(5));
        sku.setSku_unit(RandomUtil.randomStr(5));
        sku.setMin_price(RandomUtil.randomStr(5));
        sku.setMax_price(RandomUtil.randomStr(5));
        sku.setUnique_id(RandomUtil.randomStr(5));
        sku.setSale_c1_id(RandomUtil.randomInteger());
        sku.setSale_c2_id(RandomUtil.randomInteger());
        sku.setSaleC1Ids(Lists.newArrayList(RandomUtil.randomInteger(), RandomUtil.randomInteger()));
        sku.setSaleC2Ids(Lists.newArrayList(RandomUtil.randomInteger(), RandomUtil.randomInteger()));
        sku.setIs_non_halal(RandomUtil.randomInteger());
        sku.setBi_id(RandomUtil.randomLong());
        sku.setBi_name(RandomUtil.randomStr(5));
        sku.setSku_sale_to_c(RandomUtil.randomInteger());
        sku.setSku_format(RandomUtil.randomStr(1));
        sku.setCore_label(Lists.newArrayList(RandomUtil.randomStr(2), RandomUtil.randomStr(3)));
        sku.setCore_label_list(Lists.newArrayList());
        sku.setDelivery_way(RandomUtil.randomInteger());
        sku.setSku_unit_size(RandomUtil.randomInteger());
        //
        sku.setCore_attrs(Lists.newArrayList(SkuCoreAttrDTO.get()));
        sku.setTemperature(RandomUtil.randomInteger());
        sku.setAttributeList(Lists.newArrayList(TagTextDTO.get(), TagTextDTO.get()));
        sku.setGoodsTagList(Lists.newArrayList(TagResDTO.get(), TagResDTO.get()));
        sku.setIs_predict_price(RandomUtil.randomInteger());
        sku.setSpu_id(RandomUtil.randomInteger());
        sku.setSpu_name(RandomUtil.randomStr(4));
        sku.setPspuId(RandomUtil.randomInteger());
        sku.setPredict_min_unit_price(RandomUtil.randomStr(3));
        sku.setPredict_max_unit_price(RandomUtil.randomStr(3));
        sku.setMax_weight_price(RandomUtil.randomStr(3));
        sku.setMin_weight_price(RandomUtil.randomStr(3));
        sku.setPurchaseLabelList(Lists.newArrayList(TagTextDTO.get()));
        sku.setSsu_id(RandomUtil.randomLong());
        sku.setSsu_fp(RandomUtil.randomInteger());
        sku.setTag(RandomUtil.randomStr(6));
        //
        sku.setTags_list(Lists.newArrayList(TagTextDTO.get()));
        sku.setPrice_unit(RandomUtil.randomStr(5));
        sku.setSku_physical_count(RandomUtil.randomInteger());
        sku.setSell_type(RandomUtil.randomInteger());
        sku.setSsi_time_limit_type(RandomUtil.randomInteger());
        sku.setSsi_st_str(RandomUtil.randomStr(4));
        sku.setSsi_et_str(RandomUtil.randomStr(3));
        sku.setP_package_deposit(RandomUtil.randomInteger());
        sku.setIs_received(RandomUtil.randomInteger());
        sku.setPop_id(RandomUtil.randomLong());
        sku.setPop_name(RandomUtil.randomStr(2));
        sku.setPop_short_name(RandomUtil.randomStr(4));
        sku.setPop_rec_buy(RandomUtil.randomInteger());
        //
        sku.setSku_name(RandomUtil.randomStr(3));
        sku.setAttr_list(Collections.singletonMap("other", AttrInfoDTO.get()));
        sku.setLucency_pics(Lists.newArrayList(RandomUtil.randomStr(10), RandomUtil.randomStr(10)));
        sku.setSsb_desc(RandomUtil.randomStr(10));
        sku.setIs_online(RandomUtil.randomInteger());
        sku.setIs_merchant_price(RandomUtil.randomInteger());
        sku.setSell_brand(RandomUtil.randomStr(10));
        sku.setCompensate_ratio(10.20D);
        sku.setDelivery_date_type(RandomUtil.randomInteger());
        sku.setEffect_start_date(RandomUtil.randomInteger());
        sku.setEffect_end_date(RandomUtil.randomInteger());
        sku.setDelivery_start_date(RandomUtil.randomLong());
        sku.setDelivery_end_date(RandomUtil.randomLong());
        sku.setDelivery_delay_start(RandomUtil.randomInteger());
        sku.setDelivery_delay_end(RandomUtil.randomInteger());
        sku.setTags_type(RandomUtil.randomInteger());
        sku.setGoods_labels(Lists.newArrayList(RandomUtil.randomStr(1), RandomUtil.randomStr(20)));
        sku.setTotal_format(RandomUtil.randomStr(10));
        sku.setPop_type(RandomUtil.randomInteger());
        sku.setPromote_type(Lists.newArrayList(RandomUtil.randomInteger()));
        sku.setBig_activity_id(RandomUtil.randomStr(10));
        sku.setActivity_id(RandomUtil.randomLong());
        sku.setSuit_activity_id(RandomUtil.randomLong());
        sku.setPromote_st_str(RandomUtil.randomStr(10));
        sku.setPromote_et_str(RandomUtil.randomStr(10));
        sku.setPromote_can_buy_num(RandomUtil.randomInteger());
        sku.setPromote_activity_tag(Lists.newArrayList(RandomUtil.randomInteger(), RandomUtil.randomInteger()));
        //
        sku.setPurchase_price_remind_info(ActivityRemindInfoDTO.get());
        sku.setCoupon_list(Lists.newArrayList(CouponDTO.get(), CouponDTO.get()));
        sku.setStock_num(RandomUtil.randomInteger());
        sku.setAvailable_amount(RandomUtil.randomInteger());
        sku.setExpect_arrived_time(RandomUtil.randomLong());
        sku.setExpect_arrived_remind(RandomUtil.randomStr(10));
        //
        sku.setStatus_remind_info(StatusRemindInfoDTO.get());
        sku.setIs_show_weight_unit_price(RandomUtil.randomInteger());
        sku.setWeight_unit_price(RandomUtil.randomStr(10));
        //
        sku.setWeight_original_unit_price(RandomUtil.randomStr(10));
        sku.setWeight_price_unit(RandomUtil.randomStr(5));
        sku.setPrice_type(RandomUtil.randomInteger());
        sku.setPackage_price(RandomUtil.randomStr(5));
        sku.setUnit_price(RandomUtil.randomStr(5));
        sku.setTotal_price(RandomUtil.randomStr(5));
        sku.setTotal_price_with_fp(RandomUtil.randomStr(5));
        sku.setTotal_price_include_package(RandomUtil.randomStr(5));
        sku.setOriginal_unit_price(RandomUtil.randomStr(5));
        sku.setOriginal_price(RandomUtil.randomStr(5));
        sku.setOriginal_price_include_package(RandomUtil.randomStr(5));
        sku.setGoods_status(RandomUtil.randomInteger());
        sku.setStatus(RandomUtil.randomInteger());
        sku.setSortStatus(RandomUtil.randomInteger());
        //
        sku.setSuits_ssu_list(Lists.newArrayList(ProdActivityDTO.get()));
        sku.setActivity_type(RandomUtil.randomInteger());
        sku.setDeposit_rejected_days(RandomUtil.randomInteger());
        sku.setSku_package_num(RandomUtil.randomInteger());
        sku.setLimit_buy_num(RandomUtil.randomInteger());
        sku.setSbu_name(RandomUtil.randomStr(5));
        sku.setDisplay_minunit_price(RandomUtil.randomInteger());
        sku.setSsu_format(RandomUtil.randomStr(5));
        //
        sku.setActivity_list(Lists.newArrayList(ActivityInfo.get(), ActivityInfo.get()));
        sku.setFormat_type(RandomUtil.randomInteger());
        sku.setTotal_goods_num(RandomUtil.randomInteger());
        sku.setDisplay_tags(Lists.newArrayList(DisplayTagDTO.get()));
        sku.setIs_member_price(RandomUtil.randomInteger());
        sku.setMember_price(RandomUtil.randomStr(5));
        sku.setMember_total_price(RandomUtil.randomStr(5));
        sku.setWeight_member_price(RandomUtil.randomStr(5));
        //
        sku.setMember_day(MemberDayDTO.get());
        sku.setStore_info(ShopDTO.get());
        sku.setSsu_fp_text(RandomUtil.randomStr(5));
        sku.setPhysical_unit(RandomUtil.randomStr(5));
        sku.setSku_ssu_format(RandomUtil.randomStr(5));
        sku.setPredict_unit_price(RandomUtil.randomStr(5));
        sku.setPredict_total_price(RandomUtil.randomStr(5));
        sku.setPredict_price_type(RandomUtil.randomInteger());
        sku.setPredictPriceTypePrefixText(RandomUtil.randomStr(5));
        sku.setNew_over_time(RandomUtil.randomInteger());
        //
        sku.setPromotion_remind_info(SuSkuInfoResDTO.PromotionRemindInfo.get());
        sku.setSsb_pic(RandomUtil.randomStr(3));
        sku.setLevel(RandomUtil.randomStr(3));
        sku.setPop_url(RandomUtil.randomStr(3));
        sku.setShow_more_type(RandomUtil.randomInteger());
        sku.setPackage_price_msg(RandomUtil.randomStr(7));
        sku.setPreposition_deposit_msg(RandomUtil.randomStr(3));
        sku.setDeposit_info(RandomUtil.randomStr(3));
        sku.setIs_reward_goods(RandomUtil.randomInteger());
        sku.setReward_desc(RandomUtil.randomStr(3));
        sku.setLock_info(SuSkuInfoResDTO.LockInfo.get());
        sku.setPromote_tag(RandomUtil.randomStr(3));
        sku.setPromote_tag_name(RandomUtil.randomStr(3));
        sku.setPromote_gifts(Lists.newArrayList());
        sku.setPromote_tag_pics(Lists.newArrayList(RandomUtil.randomStr(3), RandomUtil.randomStr(3)));
        sku.setPromote_type_arr(Lists.newArrayList(RandomUtil.randomStr(3)));
        //
        sku.setPromote_info(SuSkuInfoResDTO.PromoteInfo.get());
        sku.setUse_225_style(RandomUtil.randomInteger());
        sku.setUse_226_style(RandomUtil.randomInteger());
        sku.setIs_replace(RandomUtil.randomInteger());
        sku.setSpm(Collections.singletonMap("aaa", "bbb"));
        sku.setExtension_ids(Lists.newArrayList(RandomUtil.randomLong()));
        //
        sku.setPromote(Lists.newArrayList(ActivityInfo.get()));
        sku.setIs_alone_sale(RandomUtil.randomInteger());
        sku.setAppointment_day(RandomUtil.randomStr(3));
        sku.setHas_package(RandomUtil.randomInteger());
        sku.setRejected_way(RandomUtil.randomInteger());
        sku.setRejected_time(RandomUtil.randomInteger());
        sku.setPay_way(RandomUtil.randomInteger());
        sku.setSale_limit_amount(RandomUtil.randomInteger());
        //
        sku.setObject_type(RandomUtil.randomStr(3));
        sku.setRecommend_type(RandomUtil.randomInteger());
        sku.setRecommend_tags(Lists.newArrayList(TagTextDTO.get()));
        sku.setDiscount_price(RandomUtil.randomStr(3));
        sku.setTitle_tag_list(TagTextDTO.get());
        sku.setTitle_tags_list(Lists.newArrayList(TagTextDTO.get()));
        sku.setIs_core_product(RandomUtil.randomStr(3));
        sku.setCore_product_type(RandomUtil.randomStr(3));
        sku.setFormat_info(RandomUtil.randomStr(3));
        sku.setPromote_price(new BigDecimal(200));
        sku.setGroup_id(RandomUtil.randomInteger());
        sku.setAd_info_id(RandomUtil.randomStr(3));
        sku.setAd_position(RandomUtil.randomStr(3));
        sku.setAd_tag(RandomUtil.randomStr(3));
        sku.setPromise_code(RandomUtil.randomStr(3));
        //
        sku.setReplace_info(SuSkuInfoResDTO.ReplaceInfo.get());
        sku.setSale_class1_id(RandomUtil.randomInteger());
        sku.setSale_class2_id(RandomUtil.randomInteger());
        sku.setPop_tags(Lists.newArrayList(TagTextDTO.get()));
        //
        sku.setPredict_ssu_unit_price_text(PredictPriceTextDTO.get());
        sku.setPredict_detail_price_text(PredictPriceTextDTO.get());
        sku.setPredict_sku_unit_price_text(PredictPriceTextDTO.get());
        sku.setTickerInfo(Collections.singletonMap("bbb", "ddd"));
        sku.setSku_all_format("aaa");
        sku.setPrice_shield(RandomUtil.randomInteger());
        sku.setShield_text(RandomUtil.randomStr(10));
        //
        sku.setSpm_info(Collections.singletonMap("abc", "jack"));
        sku.setIs_effective(RandomUtil.randomInteger());
        sku.setPackage_price_str(RandomUtil.randomStr(10));
        sku.setTimestamp(RandomUtil.randomInteger());
        sku.setIs_most_buy(RandomUtil.randomInteger());
        sku.setIs_minimum_price(RandomUtil.randomInteger());
        sku.setIs_explosive_goods(RandomUtil.randomInteger());
        sku.setPurchaseOtherProductText(RandomUtil.randomStr(10));
        sku.setMj_notice(RandomUtil.randomStr(10));
        //
        sku.setCoupon_info(SuSkuInfoResDTO.SsuCouponInfo.get());
        sku.setVip_remind_info(new HashMap<>());
        sku.setReward_goods_tag(TagTextDTO.get());
        sku.setNewCustomer(NewCustomerResDTO.get());
        sku.setService_support(Lists.newArrayList(SupportInfoDTO.get(), SupportInfoDTO.get()));
        sku.setAftersale_info(new AfterSaleInfoDTO());
        sku.setAftersale_banner(new SuSkuInfoResDTO.AfterSaleBannerInfo());
        sku.setExtra_img(Lists.newArrayList(RandomUtil.randomStr(10), RandomUtil.randomStr(10)));
        //
        sku.setDelivery_info(DeliveryInfoDTO.get());
        sku.setSale_volume(RandomUtil.randomStr(10));
        sku.setWeight_price(RandomUtil.randomLong());
        sku.setWeight_unit_name(RandomUtil.randomStr(10));
        sku.setTag_unit(RandomUtil.randomStr(10));
        sku.setSet_bottom(true);
        sku.setSku_stock_num(RandomUtil.randomInteger());
        sku.setConfigure_attributes(RandomUtil.randomStr(10));
        sku.setLabels(Lists.newArrayList(RandomUtil.randomStr(10), RandomUtil.randomStr(10)));
        sku.setIs_gray_unit_price(false);
        sku.setDelivery_text(RandomUtil.randomStr(10));
        sku.setIs_hint(RandomUtil.randomInteger());
        sku.setIsPerformanceTag(true);
        sku.setJump_url(RandomUtil.randomStr(10));
        sku.setGet_exposed_ssu_count(RandomUtil.randomInteger());
        sku.setSsu_more_text(RandomUtil.randomStr(10));
        sku.setSsu_min_price(new BigDecimal(100));
        sku.setReplace_goods_list(Lists.newArrayList());
        sku.setIs_attention(RandomUtil.randomInteger());
        sku.setQuality_score(RandomUtil.randomStr(6));
        sku.setIs_video(RandomUtil.randomInteger());
        //
        sku.setQuality_score_label(TagTextDTO.get());
        sku.setRecommendSource(RandomUtil.randomStr(5));
        sku.setGoodsRankInfo(GoodsRankInfoDTO.get());
        sku.setFeedTopTagText(RandomUtil.randomStr(10));
        sku.setAd_type(RandomUtil.randomInteger());
        sku.setAd_pos(RandomUtil.randomInteger());
        sku.setInvoiceAbsentNotice(RandomUtil.randomInteger());
        sku.setOpportunityValue(RandomUtil.randomStr(5));
        //
        sku.setTop_volume_tag(TagTextDTO.get());
        sku.setExtraTrack(ExtraTrackDTO.get());
        sku.setDeliveryTextFlag(RandomUtil.randomInteger());
        sku.setPriceSpm(RandomUtil.randomStr(10));
        //
        sku.setRelationInfo(SuSkuInfoResDTO.RelationInfo.get());
        sku.setTagFlagList(Lists.newArrayList(DisplayTagDTO.get(), DisplayTagDTO.get()));
        sku.setGoodsTags(Lists.newArrayList(DisplayTagDTO.get(), DisplayTagDTO.get()));
        sku.setPClass1Id(RandomUtil.randomInteger());
        sku.setPClass2Id(RandomUtil.randomInteger());
        sku.setPClass3Id(RandomUtil.randomInteger());
        sku.setVideoFlag(RandomUtil.randomInteger());
        //
        sku.setSpVideoInfo(SpVideoInfoDTO.get());
        sku.setHasQualification(RandomUtil.randomInteger());
        sku.setSkuGradeName(RandomUtil.randomStr(10));
        sku.setDiffPrice(RandomUtil.randomStr(5));
        sku.setIsIncludeWeightPrice(RandomUtil.randomInteger());
        sku.setWeightIncludePriceUnit(RandomUtil.randomStr(5));
        sku.setWeightIncludeUnitPrice(RandomUtil.randomStr(5));
        sku.setWeightIsExact(RandomUtil.randomInteger());
        sku.setPredictWeightUnitPrice(RandomUtil.randomStr(5));
        sku.setPredictWeightIsExact(RandomUtil.randomInteger());
        sku.setMinPredictWeightUnitPrice(RandomUtil.randomStr(5));
        sku.setMinWeightIncludeUnitPrice(RandomUtil.randomStr(5));
        sku.setMaxWeightIncludeUnitPrice(RandomUtil.randomStr(5));
        //
        sku.setComparePrice(ComparePriceDTO.get());
        sku.setNewCustomerSpecialsTag(RandomUtil.randomStr(5));
        sku.setPromotePriceTagType(RandomUtil.randomInteger());
        sku.setPromotePriceTagImg(RandomUtil.randomStr(5));
        sku.setSsuFormatMinUnit(RandomUtil.randomStr(5));
        sku.setBuyFrequency(RandomUtil.randomInteger());
        return sku;
    }


}
