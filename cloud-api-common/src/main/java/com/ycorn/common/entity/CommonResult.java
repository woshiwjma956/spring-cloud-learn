package com.ycorn.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static CommonResult success(Object data) {
        return new CommonResult(200, "success", data);
    }

    public static CommonResult success(String msg, Object data) {
        return new CommonResult(200, msg, data);
    }


    public static CommonResult success() {
        return new CommonResult(200, "success", null);
    }

    public static CommonResult error(Integer code, String msg) {
        return new CommonResult(code, msg, null);
    }

    public static CommonResult error(String msg) {
        return new CommonResult(ErrorCode.SYSTEM_ERROR.code, msg, null);
    }

    public static CommonResult error() {
        return new CommonResult(ErrorCode.SYSTEM_ERROR.code, ErrorCode.SYSTEM_ERROR.msg, null);
    }

    @AllArgsConstructor
    enum ErrorCode {
        SYSTEM_ERROR(500, "SYSTEM_ERROR"),
        ;
        private final Integer code;
        private final String msg;
    }
}