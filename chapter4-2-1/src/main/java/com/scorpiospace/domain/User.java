package com.scorpiospace.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;

    private Long uid;

    private String uname;

    private String idCard;

    private String mobile;

    private String upwd;

    private Integer roles;

    private Date regTime;

    public User(Long uid, String uname, String idCard, String mobile, String upwd, Integer roles) {
        this.id = id;
        this.uid = uid;
        this.uname = uname;
        this.idCard = idCard;
        this.mobile = mobile;
        this.upwd= upwd;
        this.roles = roles;
    }
    public User(){}
}
