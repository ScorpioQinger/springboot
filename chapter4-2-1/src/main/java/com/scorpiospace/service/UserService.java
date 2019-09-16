package com.scorpiospace.service;

import com.scorpiospace.domain.User;

import java.util.List;

public interface UserService {

    void updateUser(User user);

    void delUser(Long uid);

    User findOne(Long uid);
}
