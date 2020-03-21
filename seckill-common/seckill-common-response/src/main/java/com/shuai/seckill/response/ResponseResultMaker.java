package com.shuai.seckill.response;

/**
 * @author yongshuai
 */
public class ResponseResultMaker {

    private final static String SUCCESS = "success";

    public static <T> ResponseResult<T> makeOkResponse() {
        return new ResponseResult<T>().setCode(StatusCode.REQUEST_SUCCESS).setMessage(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOkResponse(String msg, T data) {
        return new ResponseResult<T>()
                .setCode(StatusCode.REQUEST_SUCCESS)
                .setMessage(msg)
                .setData(data);
    }

    public static <T> ResponseResult<T> makeOkResponse(String message) {
        return new ResponseResult<T>()
                .setCode(StatusCode.REQUEST_SUCCESS)
                .setMessage(SUCCESS)
                .setMessage(message);
    }

    public static <T> ResponseResult<T> makeErrResponse(String message) {
        return new ResponseResult<T>()
                .setCode(StatusCode.REQUEST_FAILED)
                .setMessage(message);
    }

    public static <T> ResponseResult<T> makeResponse(int code, String msg) {
        return new ResponseResult<T>()
                .setCode(code)
                .setMessage(msg);
    }

    public static <T> ResponseResult<T> makeResponse(int code, String msg, T data) {
        return new ResponseResult<T>()
                .setCode(code)
                .setMessage(msg)
                .setData(data);
    }

    /**
     * 封装状态码
     */
    public static final class StatusCode {

        /**
         * 请求成功
         */
        public static final Integer REQUEST_SUCCESS = 20000;

        /**
         * 请求失败
         */
        public static final Integer REQUEST_FAILED = 50000;

        /**
         * 非法的 token
         */
        public static final Integer ILLEGAL_TOKEN = 50008;

        /**
         * 用户不存在
         */
        public static final Integer USER_NOT_FOUND = 50010;

        /**
         * 已在其他客户端登录
         */
        public static final Integer OTHER_CLIENTS_LOGGED_IN = 50012;

        /**
         * token 已过期
         */
        public static final Integer TOKEN_EXPIRED = 50014;
    }
}