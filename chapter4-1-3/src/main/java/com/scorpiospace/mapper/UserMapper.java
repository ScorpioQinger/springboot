package com.scorpiospace.mapper;

import com.scorpiospace.domain.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}