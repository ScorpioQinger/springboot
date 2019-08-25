package com.scorpiospace.exception;

import com.scorpiospace.exception.code.DBCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBException extends RuntimeException {
    private DBCode dbCode;

    DBException(){
     super();
    }

    public DBException(DBCode code){
        super(code.getMsg());
        this.dbCode = code;
    }

}
