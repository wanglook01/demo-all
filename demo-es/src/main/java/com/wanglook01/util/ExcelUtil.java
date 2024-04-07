package com.wanglook01.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.wanglook01.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
            dto.setBrand(ConstUtil.getBrand());
            dto.setImages(ConstUtil.getImages());
            dto.setPrice(new BigDecimal(MathUtil.generateRandomBetween100And999()).divide(BigDecimal.valueOf(10), RoundingMode.CEILING));
            dto.setWeight(new ProductDTO.WeightDTO(new BigDecimal(MathUtil.generateRandomBetween100And999()).divide(BigDecimal.valueOf(10), RoundingMode.CEILING).doubleValue(), "kg"));
            dto.setStock(MathUtil.generateRandomBetween100And999());
            dto.setStatus(1);
            dto.setOrigin(new ProductDTO.OriginDTO("中国", ConstUtil.getRegion(), ConstUtil.getFarm()));
            dto.setDescription(ConstUtil.getDesc());
            dto.setProductionDate(Integer.parseInt("20240" + MathUtil.generateRandomBetween100And999()));
            dto.setExpirationPeriod(MathUtil.generateRandomBetween100And999());
            dto.setOrganic(true);
            dtoList.add(dto);
        }
        System.out.println(JsonUtil.toJson(dtoList));
    }
}
