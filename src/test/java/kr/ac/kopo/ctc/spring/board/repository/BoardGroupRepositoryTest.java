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
class BoardGroupRepositoryTest {

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
	
	//1 : N create
//	@Test
//	void createOne() {
//		BoardGroup boardGroup = new BoardGroup();
//		boardGroup.setName("갤러리1");
//		boardGroupRepository.save(boardGroup);
//		
//		BoardItem boardItem1 = new BoardItem();
//		boardItem1.setAuthor("작성자1");
//		boardItem1.setCreated(new Date());
//		boardItem1.setNo(1);
//		boardItem1.setTitle("갤러리 첫글입니다");
//		boardItem1.setView(2);
//		boardItem1.setBoardGroup(boardGroup);
//		System.out.println("1번글 :" + boardGroup);
//		boardItemRepository.save(boardItem1);
//		
//		
//		BoardItem boardItem2 = new BoardItem();
//		boardItem2.setAuthor("작성자2");
//		boardItem2.setCreated(new Date());
//		boardItem2.setNo(1);
//		boardItem2.setTitle("갤러리 두번째글입니다");
//		boardItem2.setView(2);
//		boardItem2.setBoardGroup(boardGroup);
//		System.out.println("2번글:" + boardGroup);
//		boardItemRepository.save(boardItem2);
//		
//		BoardItem boardItem = boardItemRepository.findById(1).get();
//		System.out.println("Aaa");
//		
//	}
	
//	//2) eager, lazy
//	@Test
//	void selectChild() {
//		 BoardGroup boardGroup = boardGroupRepository.findById(1).get();
//         System.out.println("bbb");
//	}
	
	//3) cascade delete
	@Test
	void deleteParent() {
		boardGroupRepository.deleteById(4);
		System.out.println("삭제");
	}
}
