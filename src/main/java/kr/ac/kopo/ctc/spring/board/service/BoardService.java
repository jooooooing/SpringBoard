package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.dto.Pagination;

public interface BoardService {
	
	List<Board> getBoardList(Board board);
	
	void insertBoard(Board board);
	
	Board getBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	List<Board> searchPosts(String keyword);
	
	List<Board> getBoardListPaging(Integer pageNum);
	
	Integer[] getPageNums(Integer curPageNum);
	
	Long getBoardCount();
	
	Page<Board> pageableList(Pageable pageable);
	
}
