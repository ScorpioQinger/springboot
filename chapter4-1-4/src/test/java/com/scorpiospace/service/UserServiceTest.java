package com.scorpiospace.service;

import com.scorpiospace.domain.User;
import com.scorpiospace.utils.SnowflakeIdWorker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findAll() {

        userService.addUser(new User(new SnowflakeIdWorker(1,1).nextId(),"流川枫","17647565655","2222222",
                "152395188911043131",1));

//        Assert.assertEquals(3,userService.findAll().size());
//
//        userService.delUser(111l);
//
//        Assert.assertEquals(3,userService.findAll().size());

    }
}