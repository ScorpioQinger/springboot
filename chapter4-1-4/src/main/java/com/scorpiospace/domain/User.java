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

    private String uPwd;

    private Integer roles;

    private Date regTime;

    public User(Long uId, String uName, String idCard, String mobile, String uPwd, Integer roles) {
        this.id = id;
        this.uId = uId;
        this.uName = uName;
        this.idCard = idCard;
        this.mobile = mobile;
        this.uPwd= uPwd;
        this.roles = roles;
    }
    public User(){}
}
