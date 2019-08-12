package com.scorpiospace.domain.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName User
 * @Description 用户信息实体
 * @Author zq
 * @Date 2019/8/9 15:24
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class User  implements RowMapper<User> {
    private Integer id;
    private Long uid;
    private String name;
    private String idCard;
    private String mobile;
    private String pwd;
    private Integer roles;
    private Date regTime;

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUid(resultSet.getLong("u_id"));
        user.setName(resultSet.getString("u_name"));
        user.setMobile(resultSet.getString("mobile"));
        user.setIdCard(resultSet.getString("id_card"));
        user.setPwd(resultSet.getString("pwd"));
        user.setRoles(resultSet.getInt("roles"));
        user.setRegTime(resultSet.getTimestamp("reg_time"));
        return user;
    }
}
