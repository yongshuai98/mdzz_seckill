package com.shuai.seckill.exceptions;

import lombok.Getter;

/**
 * @author liyongshuai
 * @date 2020/4/19 20:53
 */
@Getter
public class ApiException extends RuntimeException {
    private final Result result;

    public ApiException(Result result) {
        super(result.getMsg());
        this.result = result;
    }

}
