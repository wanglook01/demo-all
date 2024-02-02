package com.wanglook01.constant;

import lombok.Data;

@Data
public class ResponseResult {

    private int code;

    private String message;

    private Object data;

    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(1);
        responseResult.setMessage("");
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult error(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(0);
        responseResult.setMessage(message);
        responseResult.setData(null);
        return responseResult;
    }
}
