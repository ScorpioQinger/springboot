package com.scorpiospace.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName MyBasicErrorController
 * @Description TODO
 * @Author zq
 * @Date 2019/8/1 10:48
 * @Version 1.0
 **/
@Slf4j
@Controller
public class MyBasicErrorController extends BasicErrorController {
    public MyBasicErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @RequestMapping(produces = "text/html",value="/500")
    public ModelAndView errorHtml500(Exception e, HttpServletRequest request, HttpServletResponse response){
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request,isIncludeStackTrace(request, MediaType.TEXT_HTML));
        return new ModelAndView("error/500", model);
    }

    @RequestMapping(produces = "text/html",value="/404")
    public ModelAndView errorHtml404(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request,isIncludeStackTrace(request, MediaType.TEXT_HTML));
        return new ModelAndView("error/404", model);
    }

}
