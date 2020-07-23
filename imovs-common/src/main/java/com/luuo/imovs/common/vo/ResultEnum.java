package com.luuo.imovs.common.vo;

/**
 * 封装API的错误码
 */
public enum ResultEnum {

    SUCCESS(0, "请求成功"),
    FAIL(1, "未知的错误!"),
    PARAMETER_ERROR(1001, "请求参数有误!"),
    UNKNOWN_ERROR(9999, "未知的错误!"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
