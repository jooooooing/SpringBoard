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
		// 조회수 카운트 +1
		Board findBoard = boardRepository.findById(board.getSeq()).get();
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

	// 전체조회, 페이지2 규민코드 
	@Override
	public Page<Board> pageableList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	
	//규민코
	@Override
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) {
		// TODO Auto-generated method stub
		// Parameter : currPage : 현재 페이지 , countPerPage : 한 페이지에 보여줄 쪽 수, pageSize : 한
		// 페이지 게시글 수, totalCount : 전체 게시글 수
		if (currPage <= 1) {
			currPage = 1;
		}

		// firstPage : 제일 처음 페이지
		int firstPage = 1;

		// finalPage : 제일 마지막 페이지
		int finalPage = (int) Math.ceil((double) totalCount / pageSize); // 숫자 올림

		// 현재 페이지가 마지막 페이지보다 크면 > 현재 페이지는 마지막 페이지
		if (currPage >= finalPage) {
			currPage = finalPage;
		}

		// previousListPage : 앞 숫자 목록의 처음 숫자(<를 누르면 나오는 숫자)
		int previousListPage = (int) Math.floor((double) currPage / countPerPage);
		// int previousListPage = (currPage/countPerPage) * countPerPage + 1;

		if (previousListPage <= 1) {
			previousListPage = 1;
		} else {
			previousListPage = (previousListPage - 1) * countPerPage + 1;
		}

		// nextListPage : 다음 목록의 처음 숫자 (>를 누르면 나오는 숫자)
		int nextListPage = (int) (Math.ceil((double) currPage / countPerPage) * countPerPage) + 1;

		if (nextListPage > finalPage) {
			nextListPage = finalPage;
		}

		/*
		 * if (countPerPage <= 1) { countPerPage = 1; }
		 */

		if (totalCount == 0) {

			firstPage = 1;
			previousListPage = 1;
			nextListPage = 1;
			finalPage = 1;
			currPage = 1;

		}

		Pagination pagination = new Pagination();
		pagination.setPpPage(firstPage);
		pagination.setpPage(previousListPage);
		pagination.setnPage(nextListPage);
		pagination.setNnPage(finalPage);
		pagination.setcPage(currPage);

		return pagination;

	}
	
	//규민코드 
	@Override
	public int checkCPage(String strcPage) {
		// 현재 페이지 번호 null 체크
		int cPage;
		if (strcPage == null) {
			cPage = 0;
		} else {
			cPage = Integer.parseInt(strcPage) - 1;
		}
		return cPage;
	}

}
