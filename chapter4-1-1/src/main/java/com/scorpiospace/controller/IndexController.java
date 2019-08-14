package com.scorpiospace.controller;

import com.scorpiospace.domain.po.Result;
import com.scorpiospace.domain.po.User;
import com.scorpiospace.domain.vo.ResultVo;
import com.scorpiospace.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Slf4j
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

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUser(@RequestParam Long uid,@RequestParam String name,@RequestParam String mobile){
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        user.setUid(uid);
        userService.update(user);
        return "page/userList";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(@RequestParam("name") String name,@RequestParam("mobile") String mobile,
                          @RequestParam("idCard") String idCard,@RequestParam("roles") Integer roles){
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        user.setIdCard(idCard);
        user.setRoles(roles);
        userService.add(user);
        return ResultVo.sucess();
    }

    @RequestMapping("/del/{uid}")
    public String delUser(@PathVariable Long uid){
        userService.delete(uid);
        return "redirect:/user/list";
    }
}
