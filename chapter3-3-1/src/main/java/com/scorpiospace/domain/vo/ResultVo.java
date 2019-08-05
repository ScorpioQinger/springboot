package com.scorpiospace.domain.vo;

import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.constant.ExceptionCode;

/**
 * @ClassName ResultVo
 * @Description TODO
 * @Author zq
 * @Date 2019/7/29 15:56
 * @Version 1.0
 **/
public class ResultVo {
    /**
     * @Description   TODO 成功，无返回数据
     * @Author:       zq
     * @Date:         2019/7/29 16:01
     * @param:        []
     * @return:       com.scorpiospace.domain.po.Result<T>
     **/
    public static <T> Result<T> success(Integer code,String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * @Description   TODO 成功，有数据返回
     * @Author:       zq
     * @Date:         2019/7/29 16:14
     * @param:        [code, data]
     * @return:       com.scorpiospace.domain.po.Result<T>
     **/
    public static <T> Result<T> success(ExceptionCode code, T data){
        Result<T> result = new Result<>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * @Description   TODO 失败，无数据返回
     * @Author:       zq
     * @Date:         2019/7/29 16:20
     * @param:        [code]
     * @return:       com.scorpiospace.domain.po.Result<T>
     **/
    public static <T> Result<T> fail(Integer code,String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    /**
     * @Description   TODO 失败，有数据返回
     * @Author:       zq
     * @Date:         2019/8/5 16:18
     * @param:        [code, msg, data]
     * @return:       com.scorpiospace.domain.po.Result<T>
     **/
    public static <T> Result<T> fail(Integer code,String msg,T data){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
