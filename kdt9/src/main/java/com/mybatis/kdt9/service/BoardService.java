package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.domain.BoardEntity;
import com.mybatis.kdt9.dto.BoardDTO;
import com.mybatis.kdt9.mapper.BoardMapper;
import com.mybatis.kdt9.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;
    @Autowired
    BoardRepository boardRepository;
    //1.전체 조회
    public List<BoardDTO> getBoardAll(){
        List<BoardEntity> result=boardRepository.findAll();
        List<BoardDTO> list=new ArrayList<>();
        for(BoardEntity board:result){
            BoardDTO boardDTO=BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(new SimpleDateFormat("yyyy-MM-dd").format(board.getRegistered()))
                    .no(board.getWriter()+board.getId())
                    .build();
            list.add(boardDTO);
        }
        return list;
    }
    public void insertBoard(Board board){
        BoardEntity boardEntity=BoardEntity.builder()
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
        boardRepository.save(boardEntity);
    }
    public void patchBoard(BoardDTO boardDTO){
        BoardEntity boardEntity=boardRepository.findById(boardDTO.getId())
                .orElseThrow(()->new RuntimeException("id is wrong"));
        BoardEntity modify=BoardEntity.builder()
                .id(boardEntity.getId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .registered(boardEntity.getRegistered())
                .build();
        //save():새로운 entity를 insert ,update할 때
        //기본값 (pk)의 상태에 따라 다르게 동작
        //만약 pk값이 존재하는 경우 pk와 연결된 entity update
        //하지 않으면 insert
        boardRepository.save(modify);
        //mapper 파일에서는 여러개를 파라미터로 받을 수 있는데
        //xml은 하나밖에 못받는다.
    }
    public void deleteBoard(int id){
        BoardEntity boardEntity=boardRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("id is wrong"));
        boardRepository.delete(boardEntity);
    }
    public int searchBoard(String word){
       List<BoardEntity> result= boardRepository.getBoardByWord(word);
       return result.size();
    }
}
