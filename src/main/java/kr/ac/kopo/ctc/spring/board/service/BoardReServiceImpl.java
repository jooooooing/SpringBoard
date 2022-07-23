package kr.ac.kopo.ctc.spring.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.domain.BoardRe;
import kr.ac.kopo.ctc.spring.board.repository.BoardReRepository;

@Service
public class BoardReServiceImpl implements BoardReService{
	
	@Autowired
	BoardReRepository boardReRepository;
	
	//Create
	public void create(BoardRe boardRe) {
		boardReRepository.save(boardRe);
	}
	
	//Read
	public Page<BoardRe> readAll(String strcPage) {
		int cPage = checkCPage(strcPage);
		
		PageRequest pagealbe = PageRequest.of(cPage, COUNT_PER_PAGE);
		Page<BoardRe> page = boardReRepository.findAllByOrderBySeq(pagealbe);
		
		return page;
		
	}
	

	public BoardRe findById(int id) {
		return boardReRepository.findById((long) id).get();
	}
	
	//Update
	public void Update(BoardRe boardRe) {
		BoardRe oldBoardRe = boardReRepository.findById(boardRe.getSeq()).get();
		
		oldBoardRe.setTitle(boardRe.getTitle());
		oldBoardRe.setCreatedDate(new Date());
		oldBoardRe.setCnt(boardRe.getCnt());
		boardReRepository.save(oldBoardRe);
	}
	
	//Delete
	public void DeleteOne(int id) {
		boardReRepository.deleteById((long) id);
	}
	

	@Override
	public Pagination getPagination(String strcPage) {
		int currPage = Integer.parseInt(strcPage);

		Pagination p = new Pagination();

		// 총 레코드 수 조회
		int totalCount = getRowCount();

		// >>
		int totalPage;
		if ((totalCount % COUNT_PER_PAGE) > 0) {
			totalPage = totalCount / COUNT_PER_PAGE + 1;
		} else {
			totalPage = totalCount / COUNT_PER_PAGE;
		}

		// currPage
		if (currPage > totalPage) {
			currPage = totalPage;
		} else if (currPage < 1) {
			currPage = 1;
		}
		p.setcPage(currPage);

		// pageSize
		p.setPageSize(PAGE_SIZE);

		// <<
		p.setPpPage(1);
		// >>
		p.setNnPage(totalPage);

		// >
		if ((totalPage - currPage) < PAGE_SIZE) {
			p.setnPage(totalPage);
		} else {
			p.setnPage((currPage / PAGE_SIZE + 1) * PAGE_SIZE + 1);
		}
		// <
		if ((currPage / PAGE_SIZE) == 0) {
			p.setpPage(1);
		} else {
			p.setpPage((currPage - PAGE_SIZE / PAGE_SIZE)); // 이 부분 문데
		}

		// 첫 페이지 번호
		int startPage = (currPage / PAGE_SIZE) * PAGE_SIZE + 1;
		if ((currPage % PAGE_SIZE) == 0) {
			startPage -= PAGE_SIZE;
		}
		p.setFirstPage(startPage);

		// 마지막 페이지 번호
		int lastPage = (startPage + PAGE_SIZE - 1) >= totalPage ? totalPage : (startPage + PAGE_SIZE - 1);
		p.setLastPage(lastPage);

		if (lastPage >= totalPage) {
			p.setLastPage(totalPage);
		}

		return p;
	
	}
	
	public int getRowCount() {
		int rowcount = (int) boardReRepository.count();
		return rowcount;
	}

	@Override
	public String checkPage(String strcPage) {
		if (strcPage == null) {
			strcPage = "1";
		}
		return strcPage;
	}

	@Override
	public String newDate() {
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		// 원하는 데이터 포맷 지정
		String date = simpleDateFormat.format(nowDate);
		return date;
	}

	@Override
	public int checkCPage(String strcPage) {
		// 현재 페이지 번호 null 체크
		int cPage = 0;
		if (strcPage == null) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(strcPage);
		}
		return cPage;
	}

	@Override
	public int plusViewcnt(int inputId) {
		BoardRe boardRe = findById(inputId);
		boardRe.setCnt(boardRe.getCnt() + 1);
		boardReRepository.save(boardRe);
		return 0;
	}

	@Override
	public Long getViewcnt(int inputId) {
		Long vc = findById(inputId).getCnt();
		return vc;
	}

	@Override
	public void createItem(String writer, String title, Board board) {
		BoardRe boardRe = new BoardRe(writer, new Date(), title, board);
		boardReRepository.save(boardRe);
		
	}

	@Override
	public void deleteItem(int id) {
		BoardRe boardRe = boardReRepository.findById((long) id).get();
		boardReRepository.save(boardRe);
	}

	@Override
	public BoardRe findItem(int id) {
		return boardReRepository.findById((long)id).get();
	}
	

}
