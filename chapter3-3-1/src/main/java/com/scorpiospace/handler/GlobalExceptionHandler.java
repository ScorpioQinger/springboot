package com.scorpiospace.handler;

import com.scorpiospace.domain.po.ErrorLog;
import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.vo.ResultVo;
import com.scorpiospace.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author zq
 * @Date 2019/7/29 17:10
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MyException.class)
    public Result myExceptionHandler(MyException ex){
        logger.error("异常：",ex);
        ErrorLog errorLog = new ErrorLog();
        errorLog.setId(UUID.randomUUID().toString().replace("-",""));
        errorLog.setLogTime(new Date());
        errorLog.setLogInfo(ex.getCode()+":"+ex.getMsg());
        errorLog.setType(1);
        logger.info("异常日志入库 [{}]",errorLog.toString());
        return ResultVo.fail(ex.getCode(),ex.getMsg());
    }

}
