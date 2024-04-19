package org.example.controller;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 客户管理 /客户列表 /客户新增
 *
 * @author jasonote
 */
@Data
@SuppressWarnings("all")
public class CustomerCreateReqVO implements Serializable {


    /**
     * accountType : 3
     * groupName : Jasontoe-客户
     * brandName : 嘉松品牌
     * provinceId : 1
     * provinceName : 北京市
     * cityId : 2
     * cityName : 北京市
     * areaId : 3
     * areaName : 东城区
     * address : 北京站详细地址
     * personName : 嘉松
     * personPhone : 15652717644
     * phone : 15652717643
     * saleCode : 14280
     * saleName : 韩建敏
     * groupTypeName : 团膳
     * groupTypeCode : 102
     * licensePic : https://img-oss.stage.yunshanmeicai.com/cookbook/235186d6faeba707b1d50ecbb4fcc10c.png
     * licenseName : JJJ营业执照
     * regNum : 123456789012345
     * expireDate : 0
     * expireType : 2
     * financeGroupId :
     * settleCycleType :
     * afterPayLimit : 0
     * invoiceCycleDays :
     * checkCycleDays :
     * backMoneyCycleDays :
     * businessType : 6
     * payWay : 4
     * invoiceDelay : 7
     * estimateOrderAmount : 1
     * realOrderAmount : 30
     * isShowPrice : 1
     * supportColdChain : 1
     * isMoreDistribution : 0
     * dayCount :
     * storeNumLimit : 0
     * taxpayerType : 1
     * contractSubject : 1
     * invoiceConfigList : [{"invoiceId":null,"groupId":null,"saleClassOneId":1664,"saleClassOneName":"菜","invoiceType":1,"acceptZeroTax":2},{"invoiceId":null,"groupId":null,"saleClassOneId":1153,"saleClassOneName":"wms客户测试一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":520,"saleClassOneName":"1234","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1673,"saleClassOneName":"粉","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":522,"saleClassOneName":"预制菜","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1420,"saleClassOneName":"母婴用品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1805,"saleClassOneName":"测试问题分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1682,"saleClassOneName":"汕头海鲜","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1429,"saleClassOneName":"肉禽辅料","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1435,"saleClassOneName":"乳品饮料","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2332,"saleClassOneName":"其他鲜肉类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2333,"saleClassOneName":"冻肉类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1183,"saleClassOneName":"wms测试一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2337,"saleClassOneName":"测试0117","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1697,"saleClassOneName":"自动化一级采销分类-勿动","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1706,"saleClassOneName":"虚拟商品分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2090,"saleClassOneName":"面","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1450,"saleClassOneName":"软百服饰","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1456,"saleClassOneName":"食用油","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1585,"saleClassOneName":"org_test","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":562,"saleClassOneName":"海鲜","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2357,"saleClassOneName":"测试采购分类0527","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2102,"saleClassOneName":"流程采销一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2234,"saleClassOneName":"家具厨具","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1339,"saleClassOneName":"家居厨具","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1085,"saleClassOneName":"酒水饮品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2366,"saleClassOneName":"试一试","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1727,"saleClassOneName":"熟食","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1219,"saleClassOneName":"方便速食","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1222,"saleClassOneName":"加工调理","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1094,"saleClassOneName":"休闲零食","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2376,"saleClassOneName":"测试一级1027","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1736,"saleClassOneName":"虚拟采购一级分类36","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2124,"saleClassOneName":"【海勤专用勿动】养生系列","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1617,"saleClassOneName":"虚拟一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2258,"saleClassOneName":"豆制品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1237,"saleClassOneName":"休闲食品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2133,"saleClassOneName":"生活用品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1751,"saleClassOneName":"test924","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1880,"saleClassOneName":"油","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":478,"saleClassOneName":"虚拟商品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1118,"saleClassOneName":"JisonCG","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1246,"saleClassOneName":"虚拟","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1763,"saleClassOneName":"补货平台--蔬菜","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1892,"saleClassOneName":"liyazhi测试","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2148,"saleClassOneName":"田雨采购一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":486,"saleClassOneName":"采购分类一","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1772,"saleClassOneName":"补货平台2","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":492,"saleClassOneName":"0626","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2285,"saleClassOneName":"新鲜肉类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":2159,"saleClassOneName":"test2测试一级","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1393,"saleClassOneName":"酒类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1138,"saleClassOneName":"美家优享","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":500,"saleClassOneName":"默认分类一","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":372,"saleClassOneName":"蔬菜 lrg","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":373,"saleClassOneName":"肉禽","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":374,"saleClassOneName":"米面粮油","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":375,"saleClassOneName":"调料干货","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1655,"saleClassOneName":"查询列表测试一级分类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":376,"saleClassOneName":"水产","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":377,"saleClassOneName":"休闲酒饮","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1402,"saleClassOneName":"米","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":378,"saleClassOneName":"餐厨用品","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":379,"saleClassOneName":"水果","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":508,"saleClassOneName":"0626采购分类一","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":380,"saleClassOneName":"蛋类","invoiceType":1,"acceptZeroTax":1},{"invoiceId":null,"groupId":null,"saleClassOneId":1279,"saleClassOneName":"个人清洁","invoiceType":1,"acceptZeroTax":1}]
     * businessExtend : [1,201]
     * subtag :
     * saleRole : 在职
     * gradeLabel : 196
     * scmType : 133
     * brandType : 136
     * groupContract : [{"contractType":1,"contractStart":1664812800,"contractEnd":1669737600,"contractNo":"911007"},{"contractType":2,"contractStart":1665417600,"contractEnd":1669392000,"contractNo":"1991100"}]
     */

    //客户类型不允许为空
    private Long accountType;
    //客户名称不允许为空
    private String groupName;

    private String brandName;

    private Long provinceId;

    private String provinceName;

    private Long cityId;

    private String cityName;

    private Long areaId;

    private String areaName;

    private String address;

    //负责人
    private String personName;

    private String personPhone;

    private String phone;
    //销售
    private String saleCode;

    private String saleName;

    //业务
    private List<Integer> businessExtend;
    //合同信息
    private List<GroupContractBean> groupContract;

    private Long operatorId;
    private String operatorName;


    @Data
    public static class GroupContractBean implements Serializable {
        /**
         * contractType : 1
         * contractStart : 1664812800
         * contractEnd : 1669737600
         * contractNo : 911007
         */
        private Long contractType;
        private Long contractStart;
        private Long contractEnd;
        private Long contractStatus;
        private String contractNo;
        private Long importTime;
    }
}
