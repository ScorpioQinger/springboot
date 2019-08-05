package com.scorpiospace.handler;

import com.scorpiospace.domain.po.ErrorLog;
import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.vo.ResultVo;
import com.scorpiospace.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author zq
 * @Date 2019/7/29 17:10
 * @Version 1.0
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myExceptionHandler(MyException ex){
        log.error("异常：",ex);
        ErrorLog errorLog = new ErrorLog();
        errorLog.setId(UUID.randomUUID().toString().replace("-",""));
        errorLog.setLogTime(new Date());
        errorLog.setLogInfo(ex.getCode()+":"+ex.getMsg());
        errorLog.setType(1);
        log.info("异常日志入库 [{}]",errorLog.toString());
        return ResultVo.fail(ex.getCode(),ex.getMsg(),"MyException Handler");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result errorHandler(Exception ex) {
        log.error("异常：",ex);
        ErrorLog errorLog = new ErrorLog();
        errorLog.setId(UUID.randomUUID().toString().replace("-",""));
        errorLog.setLogTime(new Date());
        errorLog.setLogInfo(ex.getMessage());
        errorLog.setType(1);
        log.info("异常日志入库 [{}]",errorLog.toString());
        return ResultVo.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),"Exception Handler");
    }
}
