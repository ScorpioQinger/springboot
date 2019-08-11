package com.scorpiospace.domain.po;

import lombok.Getter;
import lombok.Setter;

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
public class User {
    private Integer id;
    private Long uid;
    private String name;
    private String idCard;
    private String mobile;
    private String pwd;
    private String roles;
    private Date regTime;

}
