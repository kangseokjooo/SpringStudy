package com.example.JDBC.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
    @Autowired
    //JDBC 템플릿에 의존성을 주입한다. UserJdbcRepository 필드 내에서
    private JdbcTemplate jdbc;

    private static String INSERT_USER =
            """
                INSERT INTO users (id,name,address) VALUES (?,?,?);
            """;
    private static String DELETE_USER=
            """
                DELETE FROM users WHERE id=?;
            """;
    private  static String SELECT_USER=
            """
            SELECT * FROM users WHERE id=?;
            """;

    public void  insert(Users users){
        jdbc.update(INSERT_USER,users.getId(),users.getName(),users.getAddress());
    }
    public  void delete(long id){
        jdbc.update(DELETE_USER,id);
    }
    public  Users findId(long id){
        //queryForObject
        //주어진 쿼리에 따라 데이터베이스에서 한행만 반환되길 기다릴때 사용
        //USERS클레스의 인스턴스로 매핑하기 위해서 new BeanPropertyRowMapper<>(Users.class)
        //BeanPropertyRowMapper - 데이터베이스 테이블의 칼럼 이름과 Java Bean의 프로퍼티 이름을 자동으로 매칭
        return jdbc.queryForObject(SELECT_USER,new BeanPropertyRowMapper<>(Users.class),id);
    }

    //JDBC주요 메서드
    /*
    * //update(): INSERT,UPDATE,DLELTE와 같은 SQL문 실행
    * //query():여러행을 반환하는 결과를 처리 할 때 사용
    * //excute(): 반환값이 없는 SQL명령을 실행
    * //queryForMap():단 하나의 행만 반환, 해당 데이터를 Map형태로 반환
    * //queryForInt():단일값 반환,반환값으로 int 형태 데이터(selct count(*) from dbname
    * */
}
