package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import javax.transaction.Transactional;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

public interface BoardReplyService {

		// C, U
		void createBoardReply(BoardReply boardReply);
		
		void updateBoardReply(BoardReply boardReply);
		
		// R
		BoardReply findById(Long id);
		
		List<BoardReply> findAllByBoardSeq(Long id);
		
		List<BoardReply> findAllByBoardSeqOrderByParentIdAscIdAsc(Long id);	// 전체, 원글 아이디에 해당하는 내용만
		
		// D
		@Transactional 
		void deleteOneById(Long id);
		
		@Transactional 
		void deleteAllByParentId(Long id);
	

}
