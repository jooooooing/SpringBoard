package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;
import java.util.Optional;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

public interface BoardItemService {
	
	
//	//aop
//	void test();
//	void testAopBefore();
//	void testAopAfter();
//	String testAopAfterReturning();
//	void testAopAfterThrowing();
//	void testAopAround();
//	
//	void testPointcutBefore();
//	void testPointcutAfter();
//	
//	String testPointcutAfterReturning();
//	void testPointcutAfterThrowing();
//	void testPointAround();
//	
//	String testNoAop();
//	String testAop();
//	
//	// transactional
//	String testNoTransactional();
//	String testTransactional();
	
	//게시판 전체 읽기
	List<BoardItem> selectItemAll();
	
	//하나 읽기
	Optional<BoardItem> selectItemOne(Integer id);
	
	//delete
	void deleteItem(Integer id);
	//update
	void updateItem(BoardItem boardItem);
	//insert
	void insertItem(BoardItem boardItem);
	//조회수 카운트
	void countView(Integer id);


}
