package com.scorpiospace.exception;

import com.scorpiospace.constant.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBException extends RuntimeException {
    private ResultCode resultCode;

    DBException(){
     super();
    }

    public DBException(ResultCode code){
        super(code.getMsg());
        this.resultCode = code;
    }

}
