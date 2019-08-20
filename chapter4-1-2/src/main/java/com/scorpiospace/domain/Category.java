package com.scorpiospace.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @ClassName Category 旅游类别
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 11:15
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="t_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_id",length = 32,unique = true,nullable = true)
    private Long cid;

    @Column(length = 100,unique = true)
    private String cName;
}
























