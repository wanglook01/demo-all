CREATE DATABASE mall_account;

CREATE TABLE `t_contract` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `group_id` bigint(20) NOT NULL COMMENT '客户id',
    `contract_type` tinyint(4) NOT NULL COMMENT '合同类型，1:"客户合同"，2:"三方代采协议"',
    `contract_start` int(11) NOT NULL COMMENT '合同开始时间',
    `contract_end` int(11) NOT NULL COMMENT '合同结束时间',
    `contract_status` tinyint(4) NOT NULL COMMENT '合同状态，0:待生效，1:生效中，2:预过期（还有15天过期），3:已过期，4:已作废',
    `contract_no` varchar(255) NOT NULL COMMENT '合同编号',
    `import_time` bigint(20) NOT NULL COMMENT '导入时间',
    `c_t` bigint(20) DEFAULT NULL,
    `u_t` bigint(20) DEFAULT NULL,
    `is_deleted` tinyint(4) NOT NULL COMMENT '是否已删除，0:未删除，1:已删除',
    PRIMARY KEY (`id`),
    KEY `idx_group_id` (`group_id`),
    KEY `idx_contract_no` (`contract_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='合同表';


CREATE TABLE `t_invoice_config` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `group_id` bigint(20) NOT NULL COMMENT '客户id',
    `sale_class_one_id` int(11) NOT NULL COMMENT '一级售卖分类id',
    `sale_class_one_name` varchar(255) NOT NULL COMMENT '一级售卖分类名称',
    `invoice_type` tinyint(4) NOT NULL COMMENT '发票种类，1:专票，2:普票',
    `accept_zero_tax` tinyint(4) NOT NULL COMMENT '是否接受零税点，1:接受，2:不接受',
    `c_t` bigint(20) DEFAULT NULL,
    `u_t` bigint(20) DEFAULT NULL,
    `is_deleted` tinyint(4) NOT NULL COMMENT '是否已删除，0:未删除，1:已删除',
    PRIMARY KEY (`id`),
    KEY `idx_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发票配置表';


CREATE TABLE `t_group` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL COMMENT '企业名称',
    `status` int(11) NOT NULL,
    `province_id` int(11) NOT NULL COMMENT '省份ID',
    `city_id` int(11) NOT NULL COMMENT '城市ID',
    `address_detail` varchar(255) NOT NULL COMMENT '详细地址',
    `person_name` varchar(255) NOT NULL COMMENT '联系人姓名',
    `phone` varchar(20) NOT NULL COMMENT '联系人电话',
    `sale_code` varchar(50) NOT NULL COMMENT '维护销售id',
    `label` int(11) NOT NULL COMMENT '客户标签',
    `pay_way` int(11) NOT NULL COMMENT '支付方式，1:货到付款，2:在线支付，3:账期，4:预付款',
    `day_count` int(11) DEFAULT NULL COMMENT '账期天数',
    `estimate_order_amount` decimal(10, 2) DEFAULT NULL COMMENT '日均预采购额',
    `settle_cycle_type` int(11) NOT NULL COMMENT '结算周期类型，1:按天，2:按月，3:按半月',
    `invoice_cycle_days` int(11) DEFAULT NULL COMMENT '开票周期天数',
    `back_money_cycle_days` int(11) DEFAULT NULL COMMENT '回款周期天数',
    `receive_sms_phone` varchar(255) DEFAULT NULL COMMENT '短信通知接收人（多个以逗号分隔）',
    `support_cold_chain` int(11) NOT NULL COMMENT '是否支持冷链，0:否，1:是',
    `passport_id` bigint(20) NOT NULL COMMENT 'passport_id',
    `c_t` bigint(20) DEFAULT NULL,
    `u_t` bigint(20) DEFAULT NULL,
    `is_deleted` tinyint(4) NOT NULL COMMENT '是否已删除，0:未删除，1:已删除',
    PRIMARY KEY (`id`),
    KEY `idx_city_id` (`city_id`),
    KEY `idx_passport_id` (`passport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户组信息表';


