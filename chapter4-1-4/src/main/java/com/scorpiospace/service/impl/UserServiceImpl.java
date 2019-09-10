package com.scorpiospace.service.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.User;
import com.scorpiospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.finAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(Long uid,String name) {
        userDao.updateUser(uid,name);

    }

    @Override
    public void delUser(Long uid) {
        userDao.delUser(uid);
    }

    @Override
    public User findOne(Long uid) {
        return userDao.findOne(uid);
    }
}
