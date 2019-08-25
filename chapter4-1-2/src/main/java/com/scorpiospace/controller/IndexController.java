package com.scorpiospace.controller;

import com.scorpiospace.domain.line.User;
import com.scorpiospace.repository.line.UserRepository;
import com.scorpiospace.utils.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zq
 * @Date 2019/8/15 10:19
 * @Version 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class IndexController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/add")
//    public void addUser(@RequestParam("name") String name,@RequestParam("mobile") String mobile,
//                        @RequestParam("idCard") String idCard,@RequestParam("roles") Integer roles){
//        User user = new User();
//        user.setUid(new SnowflakeIdWorker(1,1).nextId());
//        user.setName(name);
//        user.setMobile(mobile);
//        user.setIdCard(idCard);
//        user.setRoles(roles);
//        userRepository.save(user);
//    }
//
//    @PostMapping("/update/{uid}")
//    public void updateUser(@RequestParam("uid") Long uid,@RequestParam("name") String name,@RequestParam("mobile") String mobile){
//        User user = userRepository.findByUid(uid);
//        user.setName(name);
//        user.setMobile(mobile);
//        userRepository.save(user);
//    }
//
//    @GetMapping("/findOne/{idCard}")
//    @ResponseBody
//    public User findByIdCard(@RequestParam("idCard") String idCard){
//        User user = userRepository.findByIdCard(idCard);
//        return user;
//    }
//
//    @GetMapping("/findAll")
//    @ResponseBody
//    public List<User> findByAll(){
//        List<User> userList = userRepository.findAll();
//        return userList;
//    }
}
