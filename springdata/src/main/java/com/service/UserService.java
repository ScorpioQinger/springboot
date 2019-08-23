package com.service;

import com.domain.User;
import java.util.List;

public interface UserService {

    void updatNameByUid(String name,Long uid);

    void saveAll(List<User> users);
}
