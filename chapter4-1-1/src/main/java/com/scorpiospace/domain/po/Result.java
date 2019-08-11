package com.scorpiospace.domain.po;


import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Result
 * @Description TODO
 * @Author zq
 * @Date 2019/7/29 15:53
 * @Version 1.0
 **/
@Getter
@Setter
public class Result<T> {
    /*状态*/
    private Integer status;
    /*响应码*/
    private Integer code;
    /*响应描述*/
    private String msg;
    /*响应数据*/
    private T data;
}
