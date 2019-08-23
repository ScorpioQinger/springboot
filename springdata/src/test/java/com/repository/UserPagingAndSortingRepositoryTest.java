package com.repository;


import com.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class UserPagingAndSortingRepositoryTest {
    private ApplicationContext cxt;
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userPagingAndSortingRepository = cxt.getBean(UserPagingAndSortingRepository.class);
        System.out.println("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void testFindAll(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable page = PageRequest.of(0,3,sort);
        Page<User> userPage = userPagingAndSortingRepository.findAll(page);
        System.out.println("总页数 ："+userPage.getTotalPages());
        System.out.println("总记录数 ："+userPage.getTotalElements());
        System.out.println("当前页数 ："+(userPage.getNumber()+1));
        System.out.println("当前页面的数据 ："+userPage.getContent());
        System.out.println("当前页面记录数 ："+userPage.getNumberOfElements());
    }

}