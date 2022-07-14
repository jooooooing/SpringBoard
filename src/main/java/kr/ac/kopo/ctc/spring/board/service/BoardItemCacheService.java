package kr.ac.kopo.ctc.spring.board.service;

public interface BoardItemCacheService {
	String testNoCache(Long id);
	String testCache(Long id);
	void testCacheClear(Long id);

}
