package com.service.impl;

import com.domain.User;
import com.repository.UserCrudRepository;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zq
 * @Date 2019/8/22 13:43
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Transactional
    public void updatNameByUid(String name, Long uid) {
        userRepository.updateNameByUid(name,uid);
    }

    @Transactional
    public void saveAll(List<User> users) {
        userCrudRepository.saveAll(users);
    }

}
