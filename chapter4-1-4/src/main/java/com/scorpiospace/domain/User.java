package com.scorpiospace.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private Long uId;

    private String uName;

    private String idCard;

    private String mobile;

    private String pwd;

    private Integer roles;

    private Date regTime;

    public User(Long uId, String uName, String idCard, String mobile, String pwd, Integer roles) {
        this.id = id;
        this.uId = uId;
        this.uName = uName;
        this.idCard = idCard;
        this.mobile = mobile;
        this.pwd = pwd;
        this.roles = roles;
        this.regTime = regTime;
    }
}
