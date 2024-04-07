package com.wanglook01.util;

import java.util.Arrays;
import java.util.List;

public class ConstUtil {

    public static String getSkuName() {
        String[] skuNames = {
                "苹果", "香蕉",
                "橙子",
                "柠檬",
                "葡萄",
                "西瓜",
                "哈密瓜",
                "香瓜",
                "草莓",
                "芒果",
                "火龙果",
                "桃子",
                "樱桃",
                "猕猴桃",
                "菠萝",
                "柚子",
                "榴莲",
                "椰子",
                "山竹",
                "李子",
                "杏子",
                "琵琶",
                "桑葚",
                "无花果",
                "杨梅",
                "木瓜",
                "石榴",
                "荔枝",
                "龙眼",
                "甘蔗",
                "橙子（脐橙）",
                "红提",
                "黑布林",
                "牛油果",
                "百香果",
                "蓝莓",
                "榅桲",
                "水蜜桃",
                "金桔",
                "雪梨",
                "橄榄",
                "番石榴",
                "榅桲",
                "刺梨",
                "榅桲",
                "甜瓜",
                "榅桲",
                "柿子","联想笔记本电脑","华为手机","小米汽车"};
        return skuNames[MathUtil.generateRandomBetween0And49()];
    }


    public static String getBrand() {
        String[] foodBrands = {
                "雀巢",
                "联合利华",
                "可口可乐",
                "百事",
                "麦当劳",
                "星巴克",
                "蒙牛",
                "伊利",
                "达能",
                "好丽友",
                "康师傅",
                "三只松鼠",
                "农夫山泉",
                "旺旺",
                "德芙"
        };
        return foodBrands[MathUtil.generateRandomBetween0And14()];
    }

    public static List<String> getImages() {
        String[] mockImageUrls = {
                "https://example.com/image1.jpg",
                "https://example.com/image2.png",
                "https://example.com/image3.gif",
                "https://example.com/image4.webp",
                "https://example.com/image5.jpeg",
                "https://example.com/image6.bmp",
                "https://example.com/image7.tif",
                "https://example.com/image8.svg",
                "https://example.com/image9.png",
                "https://example.com/image10.jpg",
                "https://example.com/image11.webp",
                "https://example.com/image12.jpeg",
                "https://example.com/image13.gif",
                "https://example.com/image14.bmp",
                "https://example.com/image15.tif"};
        return Arrays.asList(mockImageUrls[MathUtil.generateRandomBetween0And14()], mockImageUrls[MathUtil.generateRandomBetween0And14()]);
    }


    public static String getRegion() {
        String[] provinces = {"北京市", "天津市", "河北省", "山西省",
                "内蒙古自治区", "辽宁省", "吉林省", "黑龙江省",
                "上海市", "江苏省", "浙江省", "安徽省",
                "福建省", "江西省", "湖北省"};
        return provinces[MathUtil.generateRandomBetween0And14()];
    }

    public static String getFarm() {
        String[] farmNames = {"田园牧歌农场", "绿色大地农场", "丰收谷物农场", "阳光果蔬农场",
                "锦绣山河农场", "金色麦田农场", "蓝莓之乡农场", "有机生活农场",
                "山水田园农场", "四季常青农场", "快乐老家农场", "静谧湖畔农场",
                "花海果香农场", "梦里水乡农场", "优＋农场"};
        return farmNames[MathUtil.generateRandomBetween0And14()];
    }

    public static String getDesc() {
        String[] productDescriptions = {
                "精选新鲜食材，口感鲜美回味无穷。",
                "匠心酿造法国进口红酒，浓郁果香满溢杯口。",
                "瑞士手工巧克力，丝滑细腻，多重滋味尽享。",
                "智能变频空调，节能环保，恒温调控精准。",
                "亚麻混纺休闲裤，透气舒适，时尚百搭潮流。",
                "源自生态农场有机蔬菜，绿色健康，营养均衡全面。",
                "户外防水智能运动手表，GPS定位，多项运动模式切换。",
                "美菜的西红柿和快驴的西红柿对比后哪一个更好呢"
        };

        return productDescriptions[MathUtil.generateRandomBetween0And14() / 2];
    }
}
