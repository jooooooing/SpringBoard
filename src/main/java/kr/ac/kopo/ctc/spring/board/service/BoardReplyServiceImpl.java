package kr.ac.kopo.ctc.spring.board.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.repository.BoardReplyRepository;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {
	
	
	@Autowired 
	BoardReplyRepository boardReplyRepository;
	
	@Override
	public void createBoardReply(BoardReply boardReply) {
		Board board = new Board();
		board.setSeq(boardReply.getReplyId());
		
		Date date = new Date();
		boardReply.setBoard(board);
		boardReply.setReplyRegisterDate(date);
		boardReply.setReplyUpdateDate(date);
		
		boardReplyRepository.save(boardReply);
		
		if (boardReply.getDepth() == 1) {
			boardReply.setParentId(boardReply.getId());
			boardReplyRepository.save(boardReply);
		}
		
	}

	@Override
	public void updateBoardReply(BoardReply boardReply) {
		
		Date date = new Date();
		
		BoardReply updateBoardReply = boardReplyRepository.findById(boardReply.getId()).get();
		updateBoardReply.setReplyContent(boardReply.getReplyContent());
		updateBoardReply.setReplyUpdateDate(date);
		
		boardReplyRepository.save(updateBoardReply);
		
	}
	

	@Override
	public List<BoardReply> findAllByBoardSeq(Long id) {
		List<BoardReply> replyList = boardReplyRepository.findAllByBoardSeq(id);
		return replyList;
	
	}

	@Override
	public List<BoardReply> findAllByBoardSeqOrderByParentIdAscIdAsc(Long boardId) {
		List<BoardReply> replyList = boardReplyRepository.findAllByBoardSeqOrderByParentIdAscIdAsc(boardId);
		return replyList;
	}

	@Override
	public BoardReply findById(Long id) {
		return boardReplyRepository.findById(id).get();
	}


	@Override
	@Transactional //삭제를 하는 메소드에는 Transactional을 붙여줘야함
	public void deleteById(Long id) { // 대댓글 삭제
		BoardReply boardReply = boardReplyRepository.findById(id).get();
		
		if(boardReply.getId() == boardReply.getParentId()) {
			boardReplyRepository.deleteAllByParentId(id);
		} else {
			boardReplyRepository.deleteById(id);
		}
	}



}
