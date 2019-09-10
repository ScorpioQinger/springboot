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

//        userService.addUser(new User(new SnowflakeIdWorker(1,1).nextId(),"流川枫","152395188911043131",
//                "17647565655","test2", 3));
//        userService.addUser(new User(new SnowflakeIdWorker(1,1).nextId(),"樱木花道","152395188911042626",
//                "17647565652", "test1",3));

        Assert.assertEquals(3,userService.findAll().size());
//
//        userService.delUser(111l);
//
//        Assert.assertEquals(2,userService.findAll().size());
    }

    @Test
    public void findOne() {
//        userService.updateUser(621014429563228160l,"流川枫");

//        Assert.assertEquals("流川枫",userService.findOne(621014429563228160l).getUName());
        System.out.println(userService.findOne(621014429563228160l).toString());
    }
}