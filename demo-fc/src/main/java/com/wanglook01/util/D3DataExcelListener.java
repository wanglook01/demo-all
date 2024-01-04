package com.wanglook01.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.wanglook01.dto.D3Data;

import java.util.ArrayList;
import java.util.List;

// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class D3DataExcelListener implements ReadListener<D3Data> {

    /**
     * 缓存的数据
     */
    private final List<D3Data> cachedDataList = new ArrayList<>(1000);


    public D3DataExcelListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    }

    public List<D3Data> getCachedDataList() {
        return cachedDataList;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(D3Data data, AnalysisContext context) {
        cachedDataList.add(data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        Integer rowIndex = context.readRowHolder().getRowIndex();
        System.out.println("rowIndex:" + rowIndex);
        ReadListener.super.onException(exception, context);
    }
}
