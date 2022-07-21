package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;


import kr.ac.kopo.ctc.spring.board.domain.Board;

public interface BoardService {
	

	
	List<Board> getBoardList(Board board);
	
	void insertBoard(Board board);
	
	Board getBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	List<Board> searchPosts(String keyword);
	
	List<Board> getBoardListPaging(Integer pageNum);
	
	Integer[] getPageList(Integer curPageNum);
	
	Long getBoardCount();

}
