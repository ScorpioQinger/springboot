package com.scorpiospace.service;

import com.scorpiospace.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 16:36
 * @Version 1.0
 **/
public interface UserService {
    User save(User user);

    User findOneByUid(Long uid);

    Page<User> findAll(Pageable pageable);
}
