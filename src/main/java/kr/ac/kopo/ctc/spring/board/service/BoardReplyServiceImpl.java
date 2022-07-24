package kr.ac.kopo.ctc.spring.board.service;

import java.util.Date;
import java.util.List;

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
			boardReply.setParentId(boardReply.getParentId());
		}
		
		boardReplyRepository.save(boardReply);
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
	public void deleteOneById(Long id) { // 대댓글 삭
		boardReplyRepository.deleteById(id);
	}

	@Override
	public void deleteAllByParentId(Long id) { //댓글삭제 
		boardReplyRepository.deleteAllByParentId(id);		
	}




}
