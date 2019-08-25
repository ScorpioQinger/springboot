package com.scorpiospace;

import com.scorpiospace.domain.line.User;
import com.scorpiospace.repository.line.UserRepository;
import com.scorpiospace.repository.local.LocalUserRepository;
import com.scorpiospace.utils.SnowflakeIdWorker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter412ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocalUserRepository localUserRepository;


    @Test
    public void contextLoads() {
        userRepository.save(new User(new SnowflakeIdWorker(1,1).nextId(),"樱木花道","17647565652","111111",
                "152395188911042626",1));
        userRepository.save(new User(new SnowflakeIdWorker(1,1).nextId(),"流川枫","17647565655","2222222",
                "152395188911043131",1));
        userRepository.save(new User(new SnowflakeIdWorker(1,1).nextId(),"赤木晴子","17636565652","333333",
                "152333188911042626",1));
        Assert.assertEquals(3,userRepository.findAll().size());

        Assert.assertEquals("赤木晴子",userRepository.findByIdCard("152333188911042626").getName());

        userRepository.delete(userRepository.findByIdCard("152333188911042626"));

        Assert.assertEquals(2,userRepository.findAll().size());
    }

    @Test
    public void testJpaMutifyDataSource(){
        Assert.assertEquals(8,userRepository.findAll().size());
        Assert.assertEquals(2,localUserRepository.findAll().size());

    }

}
