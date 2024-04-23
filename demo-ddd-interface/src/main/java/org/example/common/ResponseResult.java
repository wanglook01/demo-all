package org.example.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <E> ResponseResult<E> success(E data) {
        return new ResponseResult<>(1, "success", data);
    }

    public static ResponseResult<Object> failure(String message) {
        return new ResponseResult<>(0, message, null);
    }

}
