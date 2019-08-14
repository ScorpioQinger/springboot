package com.scorpiospace.service.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.po.User;
import com.scorpiospace.exception.DBException;
import com.scorpiospace.exception.code.DBCode;
import com.scorpiospace.service.IUserService;
import com.scorpiospace.utils.SnowflakeIdWorker;
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
        User u = userDao.findUserByIdCard(user.getIdCard());
        if(null != u){
            throw new DBException(DBCode.DATA_ALREADY_EXISTED);
        }
        user.setUid(new SnowflakeIdWorker(1,1).nextId());
        user.setPwd("111111");
        userDao.add(user);
    }

    @Override
    public User addtGetKey(User user) {
       return userDao.insertGetKey(user);
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
