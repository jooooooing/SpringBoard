package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
public class BoardItemMapperTest {
	
	private static final Logger Logger = LoggerFactory.getLogger(BoardItemMapperTest.class);
	
	@Autowired
	BoardItemMapper boardItemMapper;
	
//	//1) create
//	@Test
//	public void insertOne() {
//		Optional<BoardItem> boardItems = boardItemMapper.insertOne();
//	}
//	
//	//2) delete
//	@Test
//	public void deleteOne() {
//		Optional<BoardItem> boardItems = boardItemMapper.deleteOne();
//	}
//	
//	//3) update
//	@Test
//	public void updateOne() {
//		Optional<BoardItem> boardItems = boardItemMapper.updateOne();
//	}
//	
//	//4) selectAll
//	@Test
//	public void findAll() {
//		List<BoardItem> boardItems = boardItemMapper.findAll();
//		for(BoardItem boardItem : boardItems) {
//			System.out.println(boardItem.getId());
//			System.out.println(boardItem.getAuthor());
//			System.out.println(boardItem.getCreated());
//			System.out.println(boardItem.getNo());
//			System.out.println(boardItem.getTitle());
//			System.out.println(boardItem.getView());
//			
//		}
//	}
	
//	//5)selectOne(search)
//	@Test
//	public void findOneByCondition() {
//		BoardItemCondition boardItemCondition = new BoardItemCondition();
//		boardItemCondition.setAuthor("손흥민");
//		
//		List<BoardItem> boarditems = boardItemMapper.findOneByCondition(boardItemCondition);
//		for (BoardItem boardItem : boarditems) {
//		System.out.println(boardItem.getId());
//		System.out.println(boardItem.getAuthor());
//		System.out.println(boardItem.getCreated());
//		System.out.println(boardItem.getNo());
//		System.out.println(boardItem.getTitle());
//		System.out.println(boardItem.getView());
//		}
//	}
//		
//	
//	// 6)selectAll(search)
//	@Test
//	public void findAllByCondition() {
//		BoardItemCondition boardItemCondition = new BoardItemCondition();
//		RowBounds rowBounds = new RowBounds(0, 10);
//		
//		List<BoardItem> boarditems = boardItemMapper.findAllByCondition(boardItemCondition, rowBounds);
//		for (BoardItem boardItem : boarditems) {
//			System.out.println(boardItem.getId());
//			System.out.println(boardItem.getAuthor());
//			System.out.println(boardItem.getCreated());
//			System.out.println(boardItem.getNo());
//			System.out.println(boardItem.getTitle());
//			System.out.println(boardItem.getView());
//		}
//	}
	
	//7) selectAll(page)
//	@Test
//	void selectAllPage() {
//		BoardItemCondition boardItemCondition = new BoardItemCondition();
//		RowBounds rowBounds = new RowBounds(0,3); //1번째부터 3개씩 보여줌
//		List<BoardItem> boardItems = boardItemMapper.selectAllPage(boardItemCondition, rowBounds);
//		for (BoardItem boardItem : boardItems) {
//			System.out.println(boardItem.getId());
//			System.out.println(boardItem.getAuthor());
//		}
//	}
	
	//8) selectAll(search, page)
	@Test
	void selectAllSearchPage() {
		BoardItemCondition boardItemCondition = new BoardItemCondition();
		boardItemCondition.setAuthor("생성작성자");
		RowBounds rowBounds = new RowBounds(0,3); //1번째부터 3개씩 보여줌
		List<BoardItem> boardItems = boardItemMapper.selectAllPage(boardItemCondition, rowBounds);
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getId());
			System.out.println(boardItem.getAuthor());
		}
	}
	
}
