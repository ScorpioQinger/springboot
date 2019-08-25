package com.scorpiospace.domain.line;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ClassName Route 旅游路线
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 11:15
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="t_route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "r_id",length = 32,unique = true,nullable = true)
    private Long rid;

    /**旅游路线名称**/
    @Column(length = 50)
    private String routeName;

    /**价格**/
    @Column(precision = 12,scale = 2)
    private BigDecimal price;

    /**路线介绍**/
    @Column(length = 100)
    private String routeIntroduce;

    /**是否上架**/
    @Column(length = 1,columnDefinition = "int default 0")
    private Integer flag;

    /**收藏数**/
    @Column(length = 5,columnDefinition = "DATETIME comment '收藏数'")
    private Integer acount;

    /**所属分类**/
    @Column(name="c_id",length = 32,nullable = true)
    private Long cid;
}
