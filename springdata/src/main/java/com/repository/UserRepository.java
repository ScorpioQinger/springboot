package com.repository;

import com.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@RepositoryDefinition(domainClass = User.class,idClass = Integer.class)
public interface UserRepository  { // extends Repository<User,Integer>
    User findByName(String name);

    // where pwd like ?% and roles = ?
    List<User> findByPwdStartingWithAndRoles(String pwd,Integer roles);

    // where pwd like %? and regTime < ?
    List<User> findByPwdEndingWithAndRegTimeLessThan(String pwd, Date regTime);

    // where pwd in(?,?....) and regTime between ? and ?
    List<User> findByPwdInAndRegTimeBetween(List<String> pwds,Date sratTime,Date endTime);

    @Query("select o from User o where id = (select max(id) from User u)")
    User getUserByMaxId();

    @Query("select o from User o where o.name =?1 and o.pwd = ?2")
    User queryParam1(String name,String pwd);

    @Query("select o from User o where o.name = :name and o.pwd = :pwd")
    User queryParam2(@Param("name") String name, @Param("pwd") String pwd);

    @Query(nativeQuery = true,value = "select * from u_user where pwd like ?1%")
    List<User> queryLikeParam1(String tag);

    @Query(nativeQuery = true,value = "select * from u_user where pwd like :tag%")
    List<User> queryLikeParam2(@Param("tag") String tag);

    @Modifying
    @Query("update User set name = :name where uid = :uid")
    void updateNameByUid(@Param("name") String name,@Param("uid") Long uid);

}
