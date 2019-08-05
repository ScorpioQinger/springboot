package com.scorpiospace;

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
    public void error(){
        int i = 1/0;
    }

}
