package com.wanglook01.util;

import com.google.common.collect.Lists;
import com.wanglook01.dto.SuSkuInfoResDTO;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class BeanUtil {

    /**
     * 筛选商品详情的字段
     */
    public static SuSkuInfoResDTO filtrateNeedFields(SuSkuInfoResDTO ssuInfo) {
        SuSkuInfoResDTO newSsu = new SuSkuInfoResDTO();
        String fields = "ssu_id,unique_id,activity_type,unit_price,original_unit_price,original_price,original_price_include_package,total_price,total_price_include_package," +
                "package_price,package_price_msg,package_price_str,is_show_weight_unit_price,weight_unit_price,weight_original_unit_price,weight_price_unit,price_tag_pic,price_unit,is_merchant_price," +
                "is_member_price,member_price,member_total_price,member_day,weight_member_price,sale_c1_id,sale_c2_id,saleC1Ids,saleC2Ids,ssu_format,ssu_fp,price_type,ssb_desc,promote_type,status_remind_info,promotion_remind_info," +
                "big_activity_id,promote_tag,promote_tag_name,promote_gifts,promote_tag_pics,promote_info,coupon_info,promote,tags_list,is_received,delivery_date_type,deposit_rejected_days,effect_start_date,display_tags," +
                "effect_end_date,vip_remind_info,refund_remind_info,reward_goods_tag,secKill,ssu_list,price_shield,shield_text,cuisine_menu,delivery_start_date,delivery_end_date,delivery_delay_start,delivery_delay_end,compensate_ratio,lock_info,sku_physical_count,mj_notice," +
                "extra_img,delivery_info,aftersale_info,aftersale_banner,bargain_info,ssu_fp_text,is_predict_price,predict_unit_price,predict_total_price,predict_recommend_tags_detail,predict_ssu_unit_price_text,predict_detail_price_text,tag_unit,goodsRankInfo,invoiceAbsentNotice,newCustomer,activityTips";
        fields += ",service_support,mai_gui_pei";

        SuSkuInfoResDTO data = getData(ssuInfo, fields, SuSkuInfoResDTO.class);

        return data == null ? newSsu : data;
    }

    private static <T> T getData(T source, String keyStr, Class<T> clazz) {
        Set<String> keySet = new HashSet<>();
        if (keyStr == null) {
            return null;
        }
        String[] split = keyStr.split(",");
        keySet.addAll(Lists.newArrayList(split));

        T t = null;
        try {
            Constructor<T> constructor = clazz.getConstructor();
            t = constructor.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (keySet.contains(field.getName())) {
                    field.setAccessible(true);
                    field.set(t, field.get(source));
                }
            }
            return t;
        } catch (Exception e) {
            log.error("getDataError", e);
        }

        return t;
    }
}
