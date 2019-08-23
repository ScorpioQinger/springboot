package com.repository;

import com.domain.User;
import com.utils.DateTimeUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryTest {
    private ApplicationContext cxt;
    private UserRepository userRepository;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userRepository = cxt.getBean(UserRepository.class);
        System.out.println("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void findByName() {
        User user = userRepository.findByName("赤木晴子");
        System.out.println(user);
    }

    @Test
    public void testfindByPwdStartingWithAndRoles() {
        List<User> users = userRepository.findByPwdStartingWithAndRoles("test",3);
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testfindByPwdEndingWithAndRegTimeLessThan() {
        List<User> users = userRepository.findByPwdEndingWithAndRegTimeLessThan("1",DateTimeUtil.convertAsDate("2019-08-21 10:52:29"));
        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testfindByPwdInAndRegTimeBetween() {
        List<String> pwds = new ArrayList<String>();
        pwds.add("test1");
        pwds.add("test2");
        pwds.add("test3");

        List<User> users = userRepository.findByPwdInAndRegTimeBetween(pwds,
                DateTimeUtil.convertAsDate("2019-08-15"),
                DateTimeUtil.convertAsDate("2019-08-20"));
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testGetUserByMaxId(){
        User user = userRepository.getUserByMaxId();
        System.out.println(user);
    }
    @Test
    public void testQueryParam1(){
        User user = userRepository.queryParam1("樱木花道","test1");
        System.out.println(user);
    }
    @Test
    public void testQueryParam2(){
        User user = userRepository.queryParam2("樱木花道","test1");
        System.out.println(user);
    }
    @Test
    public void testQueryLikeParam1(){
        List<User> users = userRepository.queryLikeParam1("test");
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testQueryLikeParam2(){
        List<User> users = userRepository.queryLikeParam2("test");
        for (User user:users){
            System.out.println(user);
        }
    }

}