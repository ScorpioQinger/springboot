package com.scorpiospace.repository.local;


import com.scorpiospace.domain.local.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUserRepository extends JpaRepository<User,Integer> {
    @Query("from User where uid = :uid")
    User findByUid(long uid);

    User findByIdCard(String idCard);
}
