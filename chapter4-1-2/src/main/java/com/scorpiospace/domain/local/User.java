package com.scorpiospace.domain.local;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO 用户实体
 * @Author zq
 * @Date 2019/8/16 9:55
 * @Version 1.0
 **/
@Entity
@Getter
@Setter
@Table(name ="u_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_id",length = 64)
    private Long uid;

    @Column(name = "u_name",length = 32)
    private String name;

    @Column(name = "mobile",length = 11)
    private String mobile;

    @Column(name = "pwd",length = 100)
    private String pwd;

    @Column(name = "id_card",length = 18)
    private String idCard;

    @Column(name = "roles",length = 2)
    private Integer roles;

    @Column(name = "reg_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date regTime;
    //Date 日期型，精确到年月日，例如“2008-08-08”
    //Time 时间型，精确到时分秒，例如“20:00:00”
    //Timestamp 时间戳，精确到纳秒，例如“2008-08-08 20:00:00.000000001”


    public User(Long uid, String name, String mobile, String pwd, String idCard, Integer roles) {
        this.uid = uid;
        this.name = name;
        this.mobile = mobile;
        this.pwd = pwd;
        this.idCard = idCard;
        this.roles = roles;
    }

    public User(){

    }
}
