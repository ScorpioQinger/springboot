package com.dao;

import com.domain.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author zq
 * @Date 2019/8/21 10:07
 * @Version 1.0
 **/
public interface UserDAO {
    List<User> findAll();

    void save(User user);
}
