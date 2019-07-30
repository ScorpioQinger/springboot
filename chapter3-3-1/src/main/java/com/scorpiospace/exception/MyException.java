package com.scorpiospace.exception;

import com.scorpiospace.domain.constant.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName MyException
 * @Description TODO
 * @Author zq
 * @Date 2019/7/29 16:58
 * @Version 1.0
 **/
@Getter
@Setter
public class MyException extends  BaseException {
    private Integer code;
    private String msg;

    public MyException(ExceptionCode code){
        super(code.getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

}
