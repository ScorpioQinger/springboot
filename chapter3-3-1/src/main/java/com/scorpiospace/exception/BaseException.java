package com.scorpiospace.exception;

import com.scorpiospace.domain.constant.ExceptionCode;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author zq
 * @Date 2019/7/30 14:00
 * @Version 1.0
 **/
public class BaseException extends RuntimeException {
    private Integer code;
    private String msg;

    public BaseException(){
        super();
    }
    public BaseException(String _msg){
        super(_msg);
        msg = _msg;
    }
    public BaseException(ExceptionCode code){
        super(code.getMsg());
        this.code = code.getCode();
    }
}
