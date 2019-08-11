package com.scorpiospace.domain.vo;

import com.scorpiospace.constant.ResultCode;
import com.scorpiospace.domain.po.Result;

public class ResultVo {

    /**
     * TODO 成功，无数据返回
     * @param <T>
     * @return
     */
    public static  <T>Result<T> sucess(){
        Result result = new Result();
        result.setStatus(0);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        return  result;
    }

    /**
     * TODO 成功，返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T>Result<T> success(T data){
        Result result = new Result();
        result.setStatus(0);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * TODO 失败，无数据返回
     * @param code
     * @param <T>
     * @return
     */
    public static <T>Result<T> fail(ResultCode code){
        Result result = new Result();
        result.setStatus(-1);
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    /**
     * TODO 失败，返回数据
     * @param code
     * @param data
     * @param <T>
     * @return
     */
    public static <T>Result<T> fail(ResultCode code,T data){
        Result result = new Result();
        result.setStatus(-1);
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(data);
        return result;
    }
}
