package com.scorpiospace.domain.line;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Favorite 收藏夹
 * @Description TODO
 * @Author zq
 * @Date 2019/8/20 11:16
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="t_favorite")
public class Favorite {
    @Id
    @Column(length = 32)
    private Long id;

    @Column(name="r_id",length = 32)
    private Long rid;

    @Column(name="u_id",length = 32)
    private Long uid;
}
