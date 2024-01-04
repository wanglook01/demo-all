package com.wanglook01.service;

import com.wanglook01.dto.D3Data;
import com.wanglook01.util.ExcelUtil;
import com.wanglook01.util.HttpUtil;

import java.util.List;

public class D3DataService {

    public static void save() {
        List<D3Data> dataList = HttpUtil.get3DData(400);
        ExcelUtil.writeD3Data(dataList);
    }

    public static List<D3Data> get() {
        return ExcelUtil.readD3Data();
    }

    public static void main(String[] args) {
        save();
    }
}
