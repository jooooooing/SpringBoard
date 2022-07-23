package kr.ac.kopo.ctc.spring.board.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.spring.board.domain.Board;

@SpringBootTest
class BoardRepositoryTest {

	@Autowired // Autowired 하면 객체가 자동 들어감, 스프링이 자동으로 싱글톤으로 만들어줌(객체1개)
	BoardRepository boardRepository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void InsertDummy() {

		for (int i = 1; i < 201; i++) {
			Board board = new Board();
			board.setTitle("제목 " + i);
			board.setWriter("작성자 " + i);
			board.setContent("글내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);

			boardRepository.save(board);
		}

	}

}
