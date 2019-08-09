package com.scorpiospace.dao;

import com.scorpiospace.domain.po.User;

import java.util.List;

public interface UserDao {
        int add(User user);
        int update(User user);
        int delete(Long uid);
        User findUser(Long uid);
        List<User> findUserList();

}
