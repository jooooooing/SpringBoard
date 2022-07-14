package kr.ac.kopo.ctc.spring.board.service;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardItemServiceCacheTest {
	
	private static final Logger Logger = LoggerFactory.getLogger(BoardItemServiceCacheTest.class);
	
	@Autowired
	private BoardItemCacheService boardItemCacheService;
	
	private long startTime;
	private long endTime;
	
	@Before
	public void onBefore() {
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void onAfter() {
		endTime = System.currentTimeMillis();
		Logger.info("소요시간 : {}ms", endTime-startTime);
	}
	
	@Test
	public void testNoCache() {
		boardItemCacheService.testNoCache(1L);
	}
	
	@Test
	public void testCache1() {
		boardItemCacheService.testCache(1L);
	}
	
	@Test
	public void testCache2() {
		boardItemCacheService.testCache(1L);
	}
	
	@Test
	public void testCache3() {
		boardItemCacheService.testCache(2L);
	}
	
	@Test
	public void testCache4() {
		boardItemCacheService.testCache(1L);
	}
	
	@Test
	public void testCache5() {
		boardItemCacheService.testCacheClear(1L);
		boardItemCacheService.testCache(1L);
		
	}
	
}
