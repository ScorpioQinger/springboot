package com.scorpiospace.service.impl;

import com.scorpiospace.domain.User;
import com.scorpiospace.repository.UserRepository;
import com.scorpiospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 16:43
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOneByUid(Long uid) {
        return userRepository.findByUid(uid);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
