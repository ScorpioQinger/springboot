package com.scorpiospace.controller;

import com.scorpiospace.domain.constant.ExceptionCode;
import com.scorpiospace.domain.vo.ResultVo;
import com.scorpiospace.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zq
 * @Date 2019/7/30 14:59
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @RequestMapping("/")
    @ResponseBody
    public ResultVo error(){
        throw new MyException(ExceptionCode.DATA_IS_WRONG);
    }

    @RequestMapping("/ex")
    public ResultVo errorView(){
        throw new MyException(ExceptionCode.RESULE_DATA_NONE);
    }
}
