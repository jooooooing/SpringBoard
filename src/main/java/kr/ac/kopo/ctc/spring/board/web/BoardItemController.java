package kr.ac.kopo.ctc.spring.board.web;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.service.BoardItemServiceImpl;

@Controller
@RequestMapping(value = "/boardItem")
public class BoardItemController {
//	@Autowired // 한 줄마다 추가해줘야 함 컨트롤에는 serviceImpl이 더 정확함
//	private BoardItemRepository boardItemRepository;
	
	@Autowired // 한 줄마다 추가해줘야 함
	private BoardItemServiceImpl boardItemServiceImpl;
	
//	@RequestMapping(value="/board/list")
//	@ResponseBody
//	public List<BoardItem> list(Model model) {
//		return boardItemRepository.findAll();
//	}
	
//	@RequestMapping(value = "")
//	public String boardItem(Model model) {
//		model.addAttribute("name", "포스트맨");
//		return "hello";
//	}
//	
//	
//	@RequestMapping(value="/getParameter")
//	public String getParameter(Model model, HttpServletRequest req) {
//		String name = req.getParameter("name");
//		model.addAttribute("name", name);
//		return "hello";
//	}
//	
//	@RequestMapping(value="/requestParam")
//	public String requestParam(Model model, @RequestParam(value="name") String name) {
//		model.addAttribute("name", name);
//		return "hello";
//	}
//	
//	@RequestMapping(value="/pathVariable/{name}")
//	public String pathVariable(Model model, @PathVariable("name") String name) {
//		model.addAttribute("name", name);
//		return "hello";
//	}
//	
//	@RequestMapping(value="/modelAttribute")
//	public String modelAttribute(Model model, @ModelAttribute BoardItem boardItem) {
//		model.addAttribute("name", boardItem.getAuthor());
//		return "hello";
//	}
//	
//	@RequestMapping(value="/requestBody1")
//	public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
//		model.addAttribute("name", obj.get("name"));
//		return "hello";
//	}
//	
//	@RequestMapping(value="/requestBody2")
//	public String requestBody2(Model model, @RequestBody BoardItem boardItem) {
//		model.addAttribute("name", boardItem.getAuthor());
//		return "hello";
//	}
	
	@RequestMapping(value = "/allView") //게시글 전체조회
    public String allView(Model model) {
		List<BoardItem> boardItems = boardItemServiceImpl.selectItemAll();
        model.addAttribute("boardItems", boardItems);
        return "allView";
    }
	
	@RequestMapping(value="/oneView") //게시글 상세조회
	public String oneView(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		Optional<BoardItem> boardItem = boardItemServiceImpl.selectItemOne(Integer.parseInt(id));
		model.addAttribute("boardItem", boardItem.get());
		return "oneView";
	}
	
	@RequestMapping(value="/updateView") //게시글 수정 조회
	public String updateView(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		Optional<BoardItem> boardItem = boardItemServiceImpl.selectItemOne(Integer.parseInt(id));
		model.addAttribute("boardItem", boardItem.get());
		return "updateView";
	}
	
	@RequestMapping(value = "/delete") //게시글 삭제
	public String deleteItem(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		boardItemServiceImpl.deleteItem(Integer.parseInt(id));
		return "delete";
	}
	
	@RequestMapping(value = "/update") //게시글 삭제
	public String updateItem() {
	
		return "update";
	}
	
}