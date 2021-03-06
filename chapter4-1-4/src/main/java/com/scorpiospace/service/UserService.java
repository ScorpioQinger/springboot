package com.scorpiospace.service;

import com.scorpiospace.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user);

    void updateUser(Long uid,String name);

    void delUser(Long uid);

    User findOne(Long uid);
}
