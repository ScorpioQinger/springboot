package com.scorpiospace.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName Roles
 * @Description TODO
 * @Author zq
 * @Date 2019/8/16 11:47
 * @Version 1.0
 **/
@Getter
@Setter
@Entity
public class Roles {
    @Id
    private int id;
    private String roleName;
}
