package com.scorpiospace.exception.code;

import lombok.Getter;

/**
 * @ClassName BusinessCode
 * @Description TODO
 * @Author zq
 * @Date 2019/8/13 15:09
 * @Version 1.0
 **/
@Getter
public enum  BusinessCode {
    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题");

    private Integer code;
    private String msg;
    BusinessCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
