package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
class BoardItemRepositoryTest {
	
//	1)create
//	2)update
//	3)delete
//	4)selectOne
//	5)selectAll()
//	6)selectAll(search)
//	7)selectAll(page)
//	8)selectAll(search, page)	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Autowired //Autowired 하면 객체가 자동 들어감, 스프링이 자동으로 싱글톤으로 만들어줌(객체1개)
	BoardItemRepository boardItemRepository;
	@Autowired //Autowired 하면 객체가 자동 들어감, 스프링이 자동으로 싱글톤으로 만들어줌(객체1개)
	BoardGroupRepository boardGroupRepository;
//	BoardItemRepository boardItemRepository = new BoardItemRepositoryImpl;

	//1 : N create
	@Test
	void createOne() {
		BoardGroup boardGroup = new BoardGroup();
		boardGroup.setName("갤러리1");
		boardGroupRepository.save(boardGroup);
		
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setAuthor("작성자1");
		boardItem1.setCreated(new Date());
		boardItem1.setNo(1);
		boardItem1.setTitle("갤러리 첫글입니다");
		boardItem1.setView(2);
		boardItem1.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem1);
		
		BoardItem boardItem2 = new BoardItem();
		boardItem2.setAuthor("작성자2");
		boardItem2.setCreated(new Date());
		boardItem2.setNo(1);
		boardItem2.setTitle("갤러리 두번째글입니다");
		boardItem2.setView(2);
		boardItem2.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem2);
		
	}
	
////	1)create
//	@Test
//	void create() {
//		BoardItem boardItem = new BoardItem();
//		
//		boardItem.setAuthor("생성작성자");
//		boardItem.setCreated(new Date());
//		boardItem.setNo(10);
//		boardItem.setTitle("생성제목");
//		boardItem.setView(0);
//		
//		BoardItem newBoardItem = boardItemRepository.save(boardItem);
//	}
//	
////	2)Update
//	@Test
//	void update() {
//		Optional<BoardItem> boardItem = boardItemRepository.findById(1);
//		boardItem.ifPresent(selectBoardItem ->{ //람다식
//			selectBoardItem.setAuthor("업뎃작성자");
//			selectBoardItem.setCreated(new Date());
//			selectBoardItem.setNo(77);
//			selectBoardItem.setTitle("업뎃제목");
//			
//			boardItemRepository.save(selectBoardItem);
//		});
//	}
//	
//	//3)delete
//	@Test
//	void deleteById() {
//		boardItemRepository.deleteById(2);
//	}
//	
//	//4)selectOne Author
//	@Test
//	void selectOne() {
//		Optional<BoardItem> boardItemOpt = boardItemRepository.findOneByAuthor("이재성");
//		//Optional 위 메서드로 조회한 값이 존재할 수도, 존재하지 않을 수도 있기에 null에 의한 오류를 최소하기
////		위해 리턴으로 Optional로 받는다.
//		BoardItem boardItem = boardItemOpt.get();
//	}
//		
//	//5)selectAll
//	@Test
//	void selectAll() {
//		List<BoardItem> boardItems = boardItemRepository.findAll();
//	}
//	
//	//6)selectAll(search)
//	@Test
//	void selectAllSearch() {
//		boardItemRepository.findAllByTitleContaining("제목");
//	}
//	
////	7)selectAll(page)
//	@Test
//	void selectAllPage() {
//		PageRequest pageRequest = PageRequest.of(2, 1);
//		Page<BoardItem> boardItems = boardItemRepository.findAll(pageRequest);
//		System.out.println(boardItems);
//	}
//	
////	8)selectAll(search, page)	
//	@Test
//	void selectAllPageSerach() {
//		PageRequest pageRequest = PageRequest.of(2, 1);
//		boardItemRepository.findAllByTitleContaining("제목", pageRequest);
//	}
}
