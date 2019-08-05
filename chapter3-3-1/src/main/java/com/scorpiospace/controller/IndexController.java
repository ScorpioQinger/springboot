package com.scorpiospace.controller;

import com.scorpiospace.domain.constant.ExceptionCode;
import com.scorpiospace.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName IndexController
 * @Description 控制层
 * @Author zq
 * @Date 2019/7/30 14:59
 * @Version 1.0
 **/
@Slf4j
@Controller
public class IndexController {

    @RequestMapping("/ex1")
    public String throwMyException(){
        throw new MyException(ExceptionCode.RESULE_DATA_NONE);
    }

    @RequestMapping("/ex2")
    public String throwIOException() throws IOException {
        throw new IOException("This is IOException.");
    }

    @RequestMapping("/ex3")
    public String throwNullPointerException() {
        throw new NullPointerException("This is NullPointerException.");
    }

    @ExceptionHandler(NullPointerException.class)
    public String controllerExceptionHandler(HttpServletRequest req, Exception e){
        log.error("invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
    }

}
