package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, JpaSpecificationExecutor<BoardReply>{
	
	List<BoardReply> findAllByBoardSeq(Long id);
	
	List<BoardReply> findAllByBoardSeqOrderByParentIdAscIdAsc(Long id);
	
	void deleteByReplyId(Long id);
	
	void deleteAllByParentId(Long id);
	

	
}
