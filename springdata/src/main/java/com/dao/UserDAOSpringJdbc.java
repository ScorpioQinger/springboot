package com.dao;

import com.domain.User;

import java.util.List;

public interface UserDAOSpringJdbc {
    List<User> findAll();
    void save(User user);
}
