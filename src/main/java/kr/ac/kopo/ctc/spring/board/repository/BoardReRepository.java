package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.ac.kopo.ctc.spring.board.domain.BoardRe;

public interface BoardReRepository extends JpaRepository<BoardRe, Long>, JpaSpecificationExecutor<BoardRe>{
	
	List<BoardRe> findAllBySeq(long seq, Pageable pageable);
	
	Page<BoardRe> findAllByOrderBySeq(PageRequest pageable);
	
}
