package com.scorpiospace.controller;

import com.scorpiospace.domain.po.User;
import com.scorpiospace.service.IUserService;
import com.scorpiospace.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
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

    @RequestMapping("/add")
    public String addUser(@RequestParam User user){
        userService.add(user);
        return "/list";
    }

    @RequestMapping("del/{uid}")
    public String delUser(@PathVariable Long uid){
        userService.delete(uid);
        return "/list";
    }

}
