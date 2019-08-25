package com.scorpiospace.exception.code;

import lombok.Getter;

@Getter
public enum ParamsCode {
    /*参数错误 10001-19999*/
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失");

    private Integer code;
    private String msg;
    ParamsCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
