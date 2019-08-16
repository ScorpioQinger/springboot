package com.scorpiospace.repository;

import com.scorpiospace.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RolesRepository
 * @Description TODO
 * @Author zq
 * @Date 2019/8/16 11:50
 * @Version 1.0
 **/
@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
}
