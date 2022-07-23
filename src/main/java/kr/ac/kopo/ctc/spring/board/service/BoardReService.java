package kr.ac.kopo.ctc.spring.board.service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.domain.BoardRe;

public interface BoardReService {
	
	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;
	
	//페이지 불러오기
	Pagination getPagination(String strcPage);
	
	// cPage null체크
	String checkPage(String strcPage);
	
	//새로운 날짜 받기
	String newDate();
	
	// 페이지 null 체크
	public int checkCPage(String strcPage);

	// 조회수 1추가
	int plusViewcnt(int inputId);

	// 조회수 가져오기
	Long getViewcnt(int inputId);

	// 댓글 추가하기
	void createItem(String writer, String title, Board Board);

	// 댓글 삭제하기
	void deleteItem(int id);

	// 댓글 아이디로 찾기(부모 원글 아이디 찾기 용)
	BoardRe findItem(int id);
	

}
