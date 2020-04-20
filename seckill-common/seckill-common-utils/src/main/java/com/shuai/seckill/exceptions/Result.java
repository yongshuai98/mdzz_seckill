package com.shuai.seckill.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author liyongshuai
 * @date 2020/4/19 20:54
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Result {

    OPERATION_FAILED(60000, "操作失败"),
    UPDATE_FAILED(60001, "修改失败"),
    SAVE_FAILED(60002, "新增失败"),
    ;

    private int code;
    private String msg;

}
