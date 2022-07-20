package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;

@Service
public interface BoardService {
	List<Board> getBoardList(Board board);
	
	void insertBoard(Board board);
	
	Board getBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);

}
