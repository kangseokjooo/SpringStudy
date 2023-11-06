package com.board.board.repository;

import com.board.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity , Integer> {
    BoardEntity findByAuthor(String author);
    void deleteByAuthor(String author);
}
