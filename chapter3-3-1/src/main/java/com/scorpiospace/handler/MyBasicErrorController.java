package com.scorpiospace.handler;

import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
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
public class MyBasicErrorController implements ErrorController {
    private static final String ERROR_PATH="/error";
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public MyBasicErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes=errorAttributes;
    }

    @RequestMapping(value=ERROR_PATH,produces="text/html")
    public ModelAndView errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        ServletWebRequest requestAttributes =  new ServletWebRequest(request);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        ModelAndView modelAndView = new ModelAndView(ERROR_PATH);
        modelAndView.addObject("status",attr.get("status"));
        modelAndView.addObject("message",attr.get("message"));
        return modelAndView;
    }

    @RequestMapping(value=ERROR_PATH)
    @ResponseBody
    public Result errorApiHander(HttpServletRequest request) {
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> attr=this.errorAttributes.getErrorAttributes(requestAttributes, false);
        return ResultVo.fail((int) attr.get("status"),(String) attr.get("message"));
    }

}
