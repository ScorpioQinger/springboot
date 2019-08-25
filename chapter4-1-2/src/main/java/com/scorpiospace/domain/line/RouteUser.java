package com.scorpiospace.domain.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName RouteUser 描述用户于旅游的关系（多对多关系）
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 11:18
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="t_route_user")
public class RouteUser {
    @Id
    @Column(length = 64)
    private Long id;

    @Column(name="r_id",length = 64,nullable = true)
    private Long rid;

    @Column(name="u_id",length = 64,nullable = true)
    private Long uid;
}
