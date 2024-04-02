package com.wanglook01.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.wanglook01.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelUtil {

    @Data
    public static class SkuExcelDTO {
        private Integer cityId;
        private String cityName;
        private Integer newSkuId;
        private String newSkuName;
        private Integer oldSkuId;
        private String oldSkuName;
    }


    /**
     * 读取数据
     */
    @SuppressWarnings("all")
    public static <T> List<T> readFromXlsx(String filePath, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        EasyExcel.read(filePath, clazz, new PageReadListener<T>(dataList -> {
            for (T t : dataList) {
                result.add(t);
            }
        })).sheet().doRead();
        return result;
    }

    private static String getBrand() {
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

    private static List<String> getImages() {
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


    private static String getRegion() {
        String[] provinces = {"北京市", "天津市", "河北省", "山西省",
                "内蒙古自治区", "辽宁省", "吉林省", "黑龙江省",
                "上海市", "江苏省", "浙江省", "安徽省",
                "福建省", "江西省", "湖北省"};
        return provinces[MathUtil.generateRandomBetween0And14()];
    }

    private static String getFarm() {
        String[] farmNames = {"田园牧歌农场", "绿色大地农场", "丰收谷物农场", "阳光果蔬农场",
                "锦绣山河农场", "金色麦田农场", "蓝莓之乡农场", "有机生活农场",
                "山水田园农场", "四季常青农场", "快乐老家农场", "静谧湖畔农场",
                "花海果香农场", "梦里水乡农场", "优＋农场"};
        return farmNames[MathUtil.generateRandomBetween0And14()];
    }

    private static String getDesc() {
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


    public static void main(String[] args) {
        List<SkuExcelDTO> skuExcelDTOS = readFromXlsx("C:\\Users\\qingwa\\Downloads\\产品更新1-302.xlsx", SkuExcelDTO.class);
        skuExcelDTOS = skuExcelDTOS.stream().limit(20).collect(Collectors.toList());
        List<ProductDTO> dtoList = new ArrayList<>();
        for (SkuExcelDTO sku : skuExcelDTOS) {
            ProductDTO dto = new ProductDTO();
            dto.setSkuId(sku.getOldSkuId().longValue());
            dto.setSkuName(sku.getOldSkuName());
            dto.setClass1Id(MathUtil.generateRandomBetween100And999());
            dto.setClass2Id(MathUtil.generateRandomBetween100And999());
            dto.setClass3Id(MathUtil.generateRandomBetween100And999());
            dto.setBrand(getBrand());
            dto.setImages(getImages());
            dto.setPrice(new BigDecimal(MathUtil.generateRandomBetween100And999()).divide(BigDecimal.valueOf(10), RoundingMode.CEILING));
            dto.setWeight(new ProductDTO.WeightDTO(new BigDecimal(MathUtil.generateRandomBetween100And999()).divide(BigDecimal.valueOf(10), RoundingMode.CEILING).doubleValue(), "kg"));
            dto.setStock(MathUtil.generateRandomBetween100And999());
            dto.setStatus(1);
            dto.setOrigin(new ProductDTO.OriginDTO("中国", getRegion(), getFarm()));
            dto.setDescription(getDesc());
            dto.setProductionDate(Integer.parseInt("20240" + MathUtil.generateRandomBetween100And999()));
            dto.setExpirationPeriod(MathUtil.generateRandomBetween100And999());
            dto.setOrganic(true);
            dtoList.add(dto);
        }
        System.out.println(JsonUtil.toJson(dtoList));
    }
}
