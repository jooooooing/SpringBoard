package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.Board;
import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;
import kr.ac.kopo.ctc.spring.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardReplyService boardReplyService;

//	@RequestMapping("/testBoardList") //글 조회 테스트
//	public String testBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//		
//		for (int i = 0; i <100; i++) {
//			Board board = new Board();
//			board.setSeq(new Long(i));
//			board.setTitle("제목 " + i);
//			board.setWriter("작성자 " + i);
//			board.setContent("글내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
//		model.addAttribute("boardList", boardList);
//		return "testBoardList";
//	}

	// 게시글 전체조회(일반)
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardLists = boardService.getBoardList(board);
		model.addAttribute("boardList", boardLists);
		return "getBoardList";
	}

//	글 하나 조회
	@RequestMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard((board)));
		return "getBoard";
	}

//	글쓰기 화면 

	@RequestMapping("/insertBoardView")
	public String insertBoardView() {
		return "insertBoardView";
	}

//	글쓰기 처리

	@RequestMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:boardList";
	}

//	글 수정
	@RequestMapping("/updateBoard")
	public String updateBaord(Board board) {
		boardService.updateBoard(board);
		return "redirect:boardList";
	}

//	글 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:boardList";
	}

	// 글 검색
	@GetMapping("/search")
	public String search(@RequestParam(value = "keyword") String keyword, Model model, @RequestParam(value = "cPage", defaultValue = "0") Integer curPageNum) {
		model.addAttribute("keyword", keyword); // 뷰에서 받은 getparameter 저장
		List<Board> boardSearched = boardService.searchPosts(keyword); // List자료형에 search메소드 결과값 저장
		model.addAttribute("pageList", boardSearched); // boardList(getBoardList에 사용할 변수값)에 위 결과값인 boardSearched저장
		
		Integer[] pageNums = boardService.getPageNums(curPageNum);
		model.addAttribute("pageNum", pageNums);
		
		return "getBoardList";
	}

//	페이지 리스트(+페이징)
	@RequestMapping("/boardList")
	public String boardList(Model model,
			@PageableDefault(page = 0, size = 10, sort = "seq", direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "cPage", defaultValue = "0") Integer curPageNum) {
		model.addAttribute("cPage", curPageNum); // 뷰에서 받은 getparameter 저장

		Page<Board> pageLists = boardService.pageableList(pageable);
		model.addAttribute("pageList", pageLists.getContent());

		Integer[] pageNums = boardService.getPageNums(curPageNum);
		model.addAttribute("pageNum", pageNums);
		return "getBoardList";
	}
	
	//댓글 생성 
	@RequestMapping(value = "/createBoardReply")
	public String createBoardReply(BoardReply boardReply) {
		boardReplyService.createBoardReply(boardReply);
		Long toGO = boardReply.getReplyId();
		return "redirect:getBoard?seq=" + toGO + "";
	}

}
