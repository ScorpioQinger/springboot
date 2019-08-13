package com.scorpiospace.exception.code;

import lombok.Getter;

@Getter
public enum DBCode {
    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在");

    private Integer code;
    private String msg;
    DBCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
