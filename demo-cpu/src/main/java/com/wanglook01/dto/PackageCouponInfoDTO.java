package com.wanglook01.dto;

import lombok.Data;

@Data
public class PackageCouponInfoDTO {

	private Integer status;

	private Integer activity_id;

	private Integer action_id;

	private Integer receive_status;

	private Long coupon_id;

	private String coupon_name;

	private Double value;

	private Double threshold;

	private String sign;

	private String expire_str;

	private Double condition_threshold_money;

	private String condition_detail;

	private String threshold_msg;

	private Integer coupon_type;

	private String threshold_tag;

}
