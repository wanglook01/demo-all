package com.wanglook01.strategy;

import com.wanglook01.dto.D3Data;
import com.wanglook01.util.ExcelUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class V1Strategy {

    public static void main(String[] args) {
        List<D3Data> historyData = ExcelUtil.getHistoryData();
        Map<String, List<D3Data>> collect = historyData.stream().collect(Collectors.groupingBy(D3Data::getRed));
        collect.forEach((k,v)->{
            if(v.size() >= 2){
                System.out.println(v);
            }
        });

    }
}
