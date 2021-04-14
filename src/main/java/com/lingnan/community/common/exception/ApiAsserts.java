package com.lingnan.community.common.exception;

import com.lingnan.community.common.api.IErrorCode;

/**
 * @program: community
 * @description:
 * @author: Mario
 * @create: 2021-04-13 21:16
 **/
public class ApiAsserts {
    /**
     * 抛失败异常
     *
     * @param message 说明
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * 抛失败异常
     *
     * @param errorCode 状态码
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
