package com.scorpiospace.controller;

import com.scorpiospace.domain.User;
import com.scorpiospace.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zq
 * @Date 2019/9/16 9:54
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findOne/{uid}")
    public User findOne(@PathVariable("uid") Long uid){
        User user = userService.findOne(uid);
        log.info(user.toString());
        return user;
    }

    @RequestMapping("/update/{uid}/{name}")
    public void updateUser(@PathVariable("uid") Long uid,@PathVariable("name") String name){
        User user = new User();
        user.setUid(uid);
        user.setUname(name);
        userService.updateUser(user);
    }

    @RequestMapping("/del/{uid}")
    public void delUser(@PathVariable("uid") Long uid){
        userService.delUser(uid);
    }
}
