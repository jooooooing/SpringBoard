package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@RestController
@RequestMapping(value = "/rest")
public class BoardItemRestController {
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	
	@RequestMapping(value = "/boardItem1")
//	@RequestMapping(value = "/hello1", method = RequestMethod.POST) 메소드 제한걸기
	public ResponseEntity<BoardItem> boardItem1() {
		BoardItem boardItem = new BoardItem();
		boardItem.setAuthor("손흥민");
		boardItem.setTitle("우리흥");
		return ResponseEntity.ok(boardItem);
	}

	@RequestMapping(value = "/boardItems1")
	public ResponseEntity<List<BoardItem>> boardItems1() {
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setAuthor("이승우");
		boardItem1.setTitle("후전드");

		BoardItem boardItem2 = new BoardItem();
		boardItem2.setAuthor("이강인");
		boardItem2.setTitle("슛돌이");

		List<BoardItem> boardItems = new ArrayList<BoardItem>();
		boardItems.add(boardItem1);
		boardItems.add(boardItem2);

		return ResponseEntity.ok(boardItems);
	}

	@RequestMapping(value = "/boardItem2")
	public BoardItem boardItem2() {
		return boardItemRepository.findAllByBoardGroupId(1).get(0);

	}

	@RequestMapping(value = "/boardItems2")
	public List<BoardItem> boardItems2() {
		return boardItemRepository.findAllByBoardGroupId(1);

	}

}
