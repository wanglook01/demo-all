package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class StatusRemindInfoDTO {

    private String out_available_amount_remind;
    private String stock_remind;
    private String no_buy_time_show;
    private String no_buy_time_remind;
    private String status_show_name;
    private Integer available_amount;
    private Integer goods_status;
    private Integer arrived_notice_status;
    private String open_remind = "";

    private Integer promote_amount_limit_origin;
    private Integer promote_remain_amount_origin;
    private Integer remain_count;
    private List<Integer> promote_type;
    private Integer promotion_goods_num;

    private String expect_arrived_remind;

    public static StatusRemindInfoDTO get(){
        StatusRemindInfoDTO dto = new StatusRemindInfoDTO();
        dto.setOut_available_amount_remind("");
        dto.setStock_remind("");
        dto.setNo_buy_time_show("");
        dto.setNo_buy_time_remind("");
        dto.setStatus_show_name("");
        dto.setAvailable_amount(0);
        dto.setGoods_status(0);
        dto.setArrived_notice_status(0);
        dto.setOpen_remind("");
        dto.setPromote_amount_limit_origin(0);
        dto.setPromote_remain_amount_origin(0);
        dto.setRemain_count(0);
        dto.setPromote_type(new ArrayList<>());
        dto.setPromotion_goods_num(0);
        dto.setExpect_arrived_remind("");
        return dto;
    }

}
