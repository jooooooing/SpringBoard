package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.ac.kopo.ctc.spring.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	List<Board> findAll(Sort by); //역순 출력을 위한 메소드

	List<Board> findByTitleContainingOrderBySeqDesc(String keyword);

//	Page<Board> findAll(PageRequest of);
	
//	Page<Board> findAll(Pageable pageble);
	
}
