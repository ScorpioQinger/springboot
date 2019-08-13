package com.scorpiospace.dao;

import com.scorpiospace.domain.po.User;

import java.util.List;

public interface UserDao {
        /**
         * @Description   TODO 新增用户信息
         * @Author:       zq
         * @Date:         2019/8/13 14:12
         * @param:        [user]
         * @return:       int
         **/
        int add(User user);
        /**
         * @Description   TODO 新增用户信息（返回主键）-防止sql注入
         * @Author:       zq
         * @Date:         2019/8/13 14:13
         * @param:        [user]
         * @return:       com.scorpiospace.domain.po.User
         **/
        User insertGetKey(User user);

        /**
         * @Description   TODO 更新用户信息
         * @Author:       zq
         * @Date:         2019/8/13 14:13
         * @param:        [user]
         * @return:       int
         **/
        int update(User user);
        /**
         * @Description   TODO 删除用户
         * @Author:       zq
         * @Date:         2019/8/13 14:14
         * @param:        [uid]
         * @return:       int
         **/
        int delete(Long uid);
        /**
         * @Description   TODO 根据用户编号查询用户
         * @Author:       zq
         * @Date:         2019/8/13 14:14
         * @param:        [uid]
         * @return:       com.scorpiospace.domain.po.User
         **/
        User findUser(Long uid);
        /**
         * @Description   TODO 根据证件号查询用户
         * @Author:       zq
         * @Date:         2019/8/13 15:00
         * @param:        [idCard]
         * @return:       com.scorpiospace.domain.po.User
         **/
        User findUserByIdCard(String idCard);
        /**
         * @Description   TODO 获取用户列表
         * @Author:       zq
         * @Date:         2019/8/13 14:15
         * @param:        []
         * @return:       java.util.List<com.scorpiospace.domain.po.User>
         **/
        List<User> findUserList();
}
