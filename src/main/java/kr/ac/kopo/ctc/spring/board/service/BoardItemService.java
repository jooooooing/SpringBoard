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
	
	//게시판 구현
	List<BoardItem> findAll();
	//하나 읽기
	Optional<BoardItem> findById(Integer id);
	

}
