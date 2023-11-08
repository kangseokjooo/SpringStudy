package com.mybatis.kdt9.repository;

import com.mybatis.kdt9.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByName(String name);
//    UserEntity findByName(String name);
    Optional<UserEntity> findById(int id);

    @Query("SELECT u FROM UserEntity u WHERE u.name = :name or u.nickname = :nickname")
    List<UserEntity> findByNameOrNickname(@Param("name") String name, @Param("nickname") String nickname);

}
