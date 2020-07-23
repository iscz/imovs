package com.luuo.imovs.common.exception;

import com.luuo.imovs.common.vo.ResultEnum;

public class ApiException extends RuntimeException {

    private ResultEnum errorCode;

    public ApiException(ResultEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultEnum getErrorCode() {
        return errorCode;
    }
}
