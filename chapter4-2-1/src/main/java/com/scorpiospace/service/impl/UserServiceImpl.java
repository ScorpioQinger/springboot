package com.scorpiospace.service.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.User;
import com.scorpiospace.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zq
 * @Date 2019/9/12 16:16
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @CachePut(value = "users", key = "#user.uid")
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @CacheEvict(value = "users", key = "#uid")
    public void delUser(Long uid) {
        userDao.delUser(uid);
    }

    @Override
    @Cacheable(value = "users", key = "#uid")
    public User findOne(Long uid) {
        log.info("from MySql");
        return userDao.findOne(uid);
    }
}
