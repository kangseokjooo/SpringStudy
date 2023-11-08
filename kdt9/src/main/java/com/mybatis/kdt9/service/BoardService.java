package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import com.mybatis.kdt9.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;
    //1.전체 조회
    public List<BoardDTO> getBoardAll(){
        List<Board> result=boardMapper.getBoardAll();
        List<BoardDTO> list=new ArrayList<>();
        for(Board board:result){
            BoardDTO boardDTO=BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(board.getRegistered())
                    .no(board.getWriter()+board.getId())
                    .build();
            list.add(boardDTO);
        }
        return list;
    }
    public void insertBoard(Board board){
        boardMapper.insertBoard(board);
    }
    public void  patchBoard(BoardDTO boardDTO){
        boardMapper.patchBoard(boardDTO);
        //mapper 파일에서는 여러개를 파라미터로 받을 수 있는데
        //xml은 하나밖에 못받는다.
    }
    public void deleteBoard(int id){
        boardMapper.deleteBoard(id);
    }
    public int searchBoard(String word){
       List<Board> result= boardMapper.searchBoard(word);
       return result.size();
    }
}
