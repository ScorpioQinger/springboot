package com.scorpiospace.dao;

import com.scorpiospace.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    void updateUser(User user);

    void delUser(@Param("uid") Long uid);

    User findOne(@Param("uid") Long uid);
}
