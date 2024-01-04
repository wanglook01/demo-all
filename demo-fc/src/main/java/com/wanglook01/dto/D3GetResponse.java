package com.wanglook01.dto;

import lombok.Data;

import java.util.List;

@Data
public class D3GetResponse {

    private String message;

    private Integer state;

    /**
     * 第几页
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageNum;

    /**
     * 总页数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer total;

    private List<D3GetRow> result;

    @Data
    public static class D3GetRow {
        //code:"2024003"
        private String code;
        //date:"2024-01-03(三)"
        private String date;
        //name:"3D"
        private String name;
        //red:"7,2,9"
        private String red;
        //sales:"131505726"
        private String sales;
        //week:"三"
        private String week;
    }
}
