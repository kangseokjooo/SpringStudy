package com.mybatis.kdt9.repository;

import com.mybatis.kdt9.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
    @Query("select b from BoardEntity b where (b.title=:word or :word='')")
    List<BoardEntity> getBoardByWord(@Param("word") String word);
}
