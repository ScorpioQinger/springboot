package com.scorpiospace.exception;

import com.scorpiospace.exception.code.BusinessCode;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author zq
 * @Date 2019/8/13 15:07
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException {
    private BusinessCode businessCode;

    BusinessException(){
        super();
    }
    public BusinessException(BusinessCode code){
        this.businessCode = code;
    }
}
