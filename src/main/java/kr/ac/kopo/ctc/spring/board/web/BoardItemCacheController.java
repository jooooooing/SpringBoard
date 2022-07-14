//package kr.ac.kopo.ctc.spring.board.web;
//
//import java.util.HashMap;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import kr.ac.kopo.ctc.spring.board.service.BoardItemCacheService;
//import kr.ac.kopo.ctc.spring.board.service.BoardItemCacheServiceimpl;
//
//@Controller
//public class BoardItemCacheController {
//	
//	private static final Logger Logger = LoggerFactory.getLogger(BoardItemCacheController.class);
//	
//	@Autowired
//	private BoardItemCacheService boardItemCacheService;
//	
//	@RequestMapping(value = "/sample/noCache")
//	@ResponseBody
//	public String noCahce(@RequestParam HashMap<String, String> map) {
//		Long id = Long.parseLong(map.get("id"));
//		return boardItemCacheService.testNoCache(id);
//	}
//	
//	@RequestMapping(value = "/sample/Cache")
//	@ResponseBody
//	public String cache(@RequestParam HashMap<String, String> map) {
//		Long id = Long.parseLong(map.get("id"));
//		return boardItemCacheService.testCache(id);
//	}
//
//}
