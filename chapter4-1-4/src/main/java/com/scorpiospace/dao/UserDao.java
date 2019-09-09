package com.scorpiospace.dao;

import com.scorpiospace.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from u_user")
    List<User> finAll();

    @Insert("insert into u_user(u_id,u_name,id_card,mobile,pwd,roles) values(?,?,?,?,?,?)")
    void addUser(User user);

    @Update("update u_user set u_name = ?,mobile = ? where u_id = ?")
    void updateUser(User user);

    @Delete("delete from u_user where u_id = ?")
    void delUser(@Param("uid") Long uid);

    @Select("select * from u_user where u_id = ?")
    User findOne(@Param("uid") Long uid);
}
