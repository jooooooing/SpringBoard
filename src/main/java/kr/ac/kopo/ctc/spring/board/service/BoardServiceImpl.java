package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
//	@param boarod
//	@return
	
	@Override
	public List<Board> getBoardList(Board board) {
		List<Board> list = boardRepository.findAll();
		return list;
	}

	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		return null;
	}

	@Override
	public void updateBoard(Board board) {
		
	}

	@Override
	public void deleteBoard(Board board) {
		
	}

}
