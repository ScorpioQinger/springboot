package com.scopiospace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zq
 * @Date 2019/7/22 11:22
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @RequestMapping("")
    public String index(){
        return "Greeting from Spring Boot!";
    }

}
