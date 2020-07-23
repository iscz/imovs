package com.luuo.imovs.common.vo;

import lombok.Data;

import java.util.Objects;

@Data
public class ResponseResult {

    private Integer code;

    private String message;

    private Object data;

    protected ResponseResult() {
    }

    protected ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static ResponseResult success(Object data) {
        return new ResponseResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static ResponseResult success(Object data, String message) {
        return new ResponseResult(ResultEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param resultEnum 错误码
     */
    public static ResponseResult failed(ResultEnum resultEnum) {
        return new ResponseResult(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param resultEnum 错误码
     */
    public static ResponseResult failed(ResultEnum resultEnum, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(resultEnum.getCode());
        if (Objects.nonNull(message)) {
            responseResult.setMessage(message);
        } else {
            responseResult.setMessage(resultEnum.getMessage());
        }
        return responseResult;
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static ResponseResult failed(String message) {
        return new ResponseResult(ResultEnum.FAIL.getCode(), message, null);
    }
}
