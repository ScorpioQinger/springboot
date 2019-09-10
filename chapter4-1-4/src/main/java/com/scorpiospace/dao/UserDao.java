package com.scorpiospace.dao;

import com.scorpiospace.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Results({
            @Result(property="uId",column="u_id"),
            @Result(property="uName",column="u_name"),
            @Result(property="idCard",column="id_card"),
            @Result(property="uPwd",column="u_pwd"),
            @Result(property="regTime",column="reg_time")
    })
    @Select("select * from u_user")
    List<User> finAll();

    @Insert("insert into u_user(u_id,u_name,id_card,mobile,u_pwd,roles) " +
            "values(#{uId},#{uName},#{idCard},#{mobile},#{uPwd},#{roles})")
    void addUser(User user);

    @Update("update u_user set u_name = #{name} where u_id = #{uid}")
    void updateUser(@Param("uid") Long uid,@Param("name") String name);

    @Delete("delete from u_user where u_id = #{uId}")
    void delUser(@Param("uid") Long uid);

    @Results({
            @Result(property="uId",column="u_id"),
            @Result(property="uName",column="u_name"),
            @Result(property="idCard",column="id_card"),
            @Result(property="uPwd",column="u_pwd"),
            @Result(property="regTime",column="reg_time")
    })
    @Select("select * from u_user where u_id = #{uid}")
    User findOne(@Param("uid") Long uid);
}
