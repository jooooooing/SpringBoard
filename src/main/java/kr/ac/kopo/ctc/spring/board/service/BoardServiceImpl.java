package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; //역순 출력을 위한 import
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
//	@param boarod
//	@return
	
	@Override
	public List<Board> getBoardList(Board board) {
//		return (List<Board>) boardRepository.findAll();
		return (List<Board>) boardRepository.findAll(Sort.by(Sort.Direction.DESC, "seq")); //역순으로 출력 repo에 메소드 생성
	}

	@Override
	public void insertBoard(Board board) {
		board.setCnt(0L); //조회수 0으로 설정
		boardRepository.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		//조회수 카운트  +1
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		findBoard.setCnt(findBoard.getCnt()+1L);
		boardRepository.save(findBoard);
		return findBoard;
	}

	@Override
	public void updateBoard(Board board) {
		
		//수정 대상 글을 가져온다
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		
		//가져온 글에 수정한 내용을 세팅한다.
		findBoard.setTitle(board.getTitle());
		findBoard.setWriter(board.getWriter());
		findBoard.setContent(board.getContent());
		
		//DB에 저장
		boardRepository.save(findBoard);
		
	}
	
	//삭제
	@Override
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());
		
	}

}
