package com.board.board.service;

import com.board.board.dto.BoardDTO;
import com.board.board.entity.BoardEntity;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    //게시판에 글작성
    public boolean createPost(BoardDTO boardDTO){
        BoardEntity board=new BoardEntity();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setAuthor(boardDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    public List<BoardDTO> findAllBoard() {
       List<BoardEntity> allBoard = boardRepository.findAll();
       List<BoardDTO> boards=new ArrayList<>();
       for(int i=0;i<allBoard.size();i++){
           BoardDTO data=new BoardDTO();
           data.setId(allBoard.get(i).getId());
           data.setAuthor(allBoard.get(i).getAuthor());
           data.setContent(allBoard.get(i).getContent());
           data.setTitle(allBoard.get(i).getTitle());
           boards.add(data);
       }
       return boards;
    }
    public boolean updateBoard(BoardDTO boardDTO){
        Optional<BoardEntity> board=boardRepository.findById(boardDTO.getId());
        if(board.isPresent()){
          BoardEntity data = board.get();
          data.setTitle(boardDTO.getTitle());
          data.setContent(boardDTO.getContent());
          boardRepository.save(data);
        }
        return true;
    }
    @Transactional
    public boolean deleteBoard(BoardDTO boardDTO){
        boardRepository.deleteById(boardDTO.getId());
        return true;
    }

}
