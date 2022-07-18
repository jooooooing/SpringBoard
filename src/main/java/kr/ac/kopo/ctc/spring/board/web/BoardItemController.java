package kr.ac.kopo.ctc.spring.board.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;
import kr.ac.kopo.ctc.spring.board.service.BoardItemServiceImpl;

@Controller
@RequestMapping(value = "/board")
public class BoardItemController {
	@Autowired // 한 줄마다 추가해줘야 함
	private BoardItemRepository boardItemRepository;
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
	
	@RequestMapping(value = "/allView")
    public String allView(Model model) {
		List<BoardItem> list = boardItemServiceImpl.findAll();
        model.addAttribute("allView", list);
        return "allView";
    }
	
	@GetMapping("/{id}") //get방식 매핑 
	public String oneView(Model model, @PathVariable("id") String id) {
		BoardItem boardItem = boardItemRepository.findById(Integer.parseInt(id)).get();
		model.addAttribute("oneView", boardItem);
		return "oneView";
	}
}

