package com.repository;

import com.domain.User;
import com.utils.DateTimeUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;


public class UserJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext cxt;
    private UserJpaSpecificationExecutorRepository userPagingAndSortingRepository;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userPagingAndSortingRepository = cxt.getBean(UserJpaSpecificationExecutorRepository.class);
        System.out.println("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    /**
     * @Description   TODO
     *                  1)分页
     *                  2)排序
     *                  3)查询：注册时间大于2019-08-16并且小于2019-08-22的用户信息
     * @Author:       zq
     * @Date:         2019/8/22 17:03
     * @param:        []
     * @return:       void
     **/
    @Test
    public void testFindAll(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable page =  PageRequest.of(1,3,sort);
        Specification<User> specification = new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("regTime");
                criteriaBuilder.between(path,DateTimeUtil.convertAsDate("2019-08-16"),
                        DateTimeUtil.convertAsDate("2019-08-22"));

                return null;
            }
        };

        Page<User> userPage = userPagingAndSortingRepository.findAll(specification,page);
        System.out.println("总页数 ："+userPage.getTotalPages());
        System.out.println("总记录数 ："+userPage.getTotalElements());
        System.out.println("当前页数 ："+(userPage.getNumber()+1));
        System.out.println("当前页面的数据 ："+userPage.getContent());
        System.out.println("当前页面记录数 ："+userPage.getNumberOfElements());

    }

}