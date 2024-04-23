package org.example.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageDTO<T> implements Serializable {

    // 当前页码
    private int pageNum;
    // 每页大小
    private int pageSize;
    // 总记录数
    private long totalRecords;
    // 总页数
    private int totalPages;
    // 数据列表
    private List<T> dataList;

    // 构造函数
    public PageDTO(int pageNum, int pageSize, long totalRecords, List<T> dataList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        this.dataList = dataList;
    }

}
