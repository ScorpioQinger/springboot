package com.scorpiospace.controller;

import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.po.User;
import com.scorpiospace.domain.vo.ResultVo;
import com.scorpiospace.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class IndexController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public ModelAndView userList(){
        List<User> users = userService.findUserList();
        ModelAndView modelAndView = new ModelAndView("page/userList");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @RequestMapping("/find/{uid}")
    public ModelAndView findUser(@PathVariable Long uid){
        User user = userService.findUser(uid);
        ModelAndView modelAndView = new ModelAndView("page/editUser");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam User user){
        userService.update(user);
        return "/list";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addUser(@RequestParam User user){
        userService.add(user);
        return ResultVo.sucess();
    }

    @RequestMapping("/addPage")
    public String addPage(){
       return "page/addUser" ;
    }

    @RequestMapping("del/{uid}")
    public String delUser(@PathVariable Long uid){
        userService.delete(uid);
        return "/list";
    }
}
