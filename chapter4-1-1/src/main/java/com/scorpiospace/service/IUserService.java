package com.scorpiospace.service;

import com.scorpiospace.domain.po.User;

import java.util.List;

public interface IUserService {
    void add(User user);
    User addtGetKey(User user);
    void update(User user);
    void delete(Long uid);
    User findUser(Long uid);
    List<User> findUserList();
}
