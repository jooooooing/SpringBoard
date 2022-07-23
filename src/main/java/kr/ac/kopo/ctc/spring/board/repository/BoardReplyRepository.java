package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, JpaSpecificationExecutor<BoardReply>{
	
	@Query("select r from board_reply r where r.board_seq = : reply_id")
	List<BoardReply> findReplyBoardSeq(@Param("id") Integer id);
	
	
}
