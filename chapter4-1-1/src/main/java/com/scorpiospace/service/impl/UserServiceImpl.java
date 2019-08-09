package com.scorpiospace.service.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.po.User;
import com.scorpiospace.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zq
 * @Date 2019/8/9 17:25
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Long uid) {
        userDao.delete(uid);
    }

    @Override
    public User findUser(Long uid) {
        return userDao.findUser(uid);
    }

    @Override
    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
