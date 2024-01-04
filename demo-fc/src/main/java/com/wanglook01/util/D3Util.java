package com.wanglook01.util;

import com.wanglook01.dto.D3Data;
import com.wanglook01.dto.D3GetResponse;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class D3Util {

    public static List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    result.add(i + "" + j + "" + k);
                }
            }
        }
        return result;
    }

    public static List<D3Data> convert(D3GetResponse response) {
        List<D3Data> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(response.getResult())) {
            return resultList;
        }
        for (D3GetResponse.D3GetRow row : response.getResult()) {
            D3Data data = new D3Data();
            data.setCode(Integer.parseInt(row.getCode()));
            String date = row.getDate();
            data.setDate(Integer.parseInt(date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10)));
            data.setWeek(row.getWeek());
            data.setRed(row.getRed());
            data.setNum1(Integer.parseInt(row.getRed().split(",")[0]));
            data.setNum2(Integer.parseInt(row.getRed().split(",")[1]));
            data.setNum3(Integer.parseInt(row.getRed().split(",")[2]));
            data.setSales(Long.parseLong(row.getSales()));
            resultList.add(data);
        }
        return resultList;
    }
}
