package com.crud.crudtest.repository;

import com.crud.crudtest.domain.PersonEntity;
import org.aspectj.weaver.ast.And;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    //name 매개변수를 받은 PersonEntity의 name필드와 비교
    //일치하는 레코드 DB에 있을 때 해당 엔티티를 자바의 Optional 객체로 반환
    Optional<PersonEntity> findByName(String name);
    Optional<PersonEntity> findByUseridAndPassword(String userid, String password);

    PersonEntity findByUserid(String userid);


    void deleteByUserid(String userid);

    //복잡한 쿼리일때 JPQL
//    @Query("select * from seoul userid=:userid and password=:password orderby id desc limit 1")
//    Optional<PersonEntity> findByUseridAndPasswordOrderByIdDesc(@Param("userid") String userid, @Param("password") String password);
}
//Optional 클래스의 메서드
/*1.orElse
*   저장된 값이 있으면 그 값 반환 , 없으면 인자로 넘겨진 값 반환
* ex)person.orElse("no value")
*
* 2. orElseThrow(()=>{})
* 저장된 값이 있으면 그 값을 반환, 없으면 예외 처리
*
* 3.isPresent()(== isEmpty() java11버전 이상)
* 값이 존재 하면 true 없으면 false
*
* 4.filter()
* 값이 존재 하고 주어진 조건을 만족 하는 그 값을 포함 하는 Optional을 반환
* 값이 없으면 빈 Optional 반환
*
* */
