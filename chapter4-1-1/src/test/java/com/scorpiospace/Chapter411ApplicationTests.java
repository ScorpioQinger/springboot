package com.scorpiospace;

import com.scorpiospace.domain.po.User;
import com.scorpiospace.service.IUserService;
import com.scorpiospace.utils.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter411ApplicationTests {
    @Autowired
    private IUserService userService;

    @Autowired
    @Qualifier("lineJdbcTemplate")
    private JdbcTemplate lineJdbcTemplate;

    @Autowired
    @Qualifier("localJdbcTemplate")
    private JdbcTemplate localJdbcTemplate;


    @Test
    public void testLineJdbcTemplate() {
        String sql = "select count(1) from u_user";
        Assert.assertEquals("8",lineJdbcTemplate.queryForObject(sql,String.class));
    }

    @Test
    public void testLocalJdbcTemplate(){
        String sql = "insert into u_user(u_id,u_name) values(?,?)";
        localJdbcTemplate.update(sql,611925549614501888l,"樱木花道");
        Assert.assertEquals("2",localJdbcTemplate.queryForObject("select count(1) from u_user",String.class));

    }

    @Test
    public void add(){
        User user = new User();
        user.setUid(new SnowflakeIdWorker(1,1).nextId());
        user.setName("foo");
        user.setMobile("17647575742");
        user.setIdCard("110201199411017867");
        user.setPwd("123456");
        user.setRoles(3);
        userService.add(user);
    }

    @Test
    public void addGetKey(){
        User user = new User();
        user.setUid(new SnowflakeIdWorker(1,1).nextId());
        user.setName("coco");
        user.setMobile("18347062900");
        user.setIdCard("110201199312017867");
        user.setPwd("111111");
        user.setRoles(3);
        User newUser = userService.addtGetKey(user);
        log.info(newUser.toString());
    }

    @Test
    public void findUser(){
       User user = userService.findUser(611925549614501888l);
       log.info("用户信息：[{}]",user.toString());
    }

    @Test
    public void findUserList(){
        List<User> userList = userService.findUserList();
        Iterator<User> iterator = userList.iterator();
        log.info("用户信息列表：");
        while(iterator.hasNext()){
           User user =  iterator.next();
            log.info(user.toString());
        }

    }

    @Test
    public void update(){
        User user = new User();
        user.setName("coco");
        user.setMobile("18347062900");
        user.setUid(610485881870094336L);
        userService.update(user);
    }

    @Test
    public void del(){
        userService.delete(610437530340429824L);
    }

}
