package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardAll();

    List<Board>searchBoard(String word);

    void insertBoard(Board board);
    //수정
    void patchBoard(BoardDTO boardDTO);

    void deleteBoard(int id);
}
