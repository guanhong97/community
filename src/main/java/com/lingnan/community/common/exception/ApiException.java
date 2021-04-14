package com.lingnan.community.common.exception;

import com.lingnan.community.common.api.IErrorCode;

/**
 * @program: community
 * @description: 接口异常
 * @author: Mario
 * @create: 2021-04-13 21:14
 **/
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
