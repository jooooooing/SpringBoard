package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort; //역순 출력을 위한 import
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.dto.Pagination;
import kr.ac.kopo.ctc.spring.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	private static final int BLOCK_PAGE_NUM_COUNT = 5; // 한 블럭에 존재하는 페이지 수
	private static final int PAGE_POST_COUNT = 10; // 한 페이지 존재하는 게시 수

//	@param boarod
//	@return

	@Override
	public List<Board> getBoardList(Board board) {
//		return (List<Board>) boardRepository.findAll();
		return (List<Board>) boardRepository.findAll(Sort.by(Sort.Direction.DESC, "seq")); // 역순으로 출력 repo에 메소드 생성
	}

	@Override
	public void insertBoard(Board board) {
		board.setCnt(0L); // 조회수 0으로 설정
		boardRepository.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		// 조회수 카운트 +1
		findBoard.setCnt(findBoard.getCnt() + 1L);
		boardRepository.save(findBoard);
		return findBoard;
	}

	@Override
	public void updateBoard(Board board) {

		// 수정 대상 글을 가져온다
		Board findBoard = boardRepository.findById(board.getSeq()).get();

		// 가져온 글에 수정한 내용을 세팅한다.
		findBoard.setTitle(board.getTitle());
		findBoard.setWriter(board.getWriter());
		findBoard.setContent(board.getContent());

		// DB에 저장
		boardRepository.save(findBoard);

	}

	// 삭제
	@Override
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());

	}

	// 검색
	@Override
	@Transactional
	public List<Board> searchPosts(String keyword) {
		List<Board> boards = boardRepository.findByTitleContainingOrderBySeqDesc(keyword); // 제목포함, seq를 역순으로 정렬
		return boards;
	}

	// 페이징1
	@Override
	@Transactional
	public List<Board> getBoardListPaging(Integer pageNum) {

		Page<Board> page = boardRepository
				.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "seq")));

		List<Board> boards = page.getContent();

		return boards;
	}

	@Override
	public Integer[] getPageNums(Integer curPageNum) {
		
		Integer[] pageList;
		// 총 게시글 갯수
		Double postsTotalCount = Double.valueOf(this.getBoardCount());

		// 총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림)
		Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

		Integer blockStartPageNum = (curPageNum <= BLOCK_PAGE_NUM_COUNT / 2) ? 1
				: curPageNum - BLOCK_PAGE_NUM_COUNT / 2;

		// 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > blockStartPageNum + BLOCK_PAGE_NUM_COUNT - 1)
				? blockStartPageNum + BLOCK_PAGE_NUM_COUNT - 1
				: totalLastPageNum;

		// 페이지 시작 번호 조정
		curPageNum = (curPageNum <= 3) ? 1 : (curPageNum - 2);

			pageList = new Integer[BLOCK_PAGE_NUM_COUNT];
			for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
				pageList[idx] = val;
			}

		return pageList;
	}

	// 총 게시글 갯수 구하는 메소드
	@Override
	public Long getBoardCount() {
		return boardRepository.count();
	}

	// 전체조회, 페이징
	@Override
	public Page<Board> pageableList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	

}
