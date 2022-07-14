package kr.ac.kopo.ctc.spring.board.service;

public interface BoardItemService {
	
	
	//aop
	void test();
	void testAopBefore();
	void testAopAfter();
	String testAopAfterReturning();
	void testAopAfterThrowing();
	void testAopAround();
	
	void testPointcutBefore();
	void testPointcutAfter();
	
	String testPointcutAfterReturning();
	void testPointcutAfterThrowing();
	void testPointAround();
	
	String testNoAop();
	String testAop();
	
	// transactional
	String testNoTransactional();
	String testTransactional();


}
