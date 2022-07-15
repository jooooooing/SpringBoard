package kr.ac.kopo.ctc.spring.board.web;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Controller
@RequestMapping(value = "/board")
public class BoardItemController {
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@RequestMapping(value="/board/list")
	@ResponseBody
	public List<BoardItem> list(Model model) {
		return boardItemRepository.findAll();
	}
	
	@RequestMapping(value = "")
	public String boardItem(Model model) {
		model.addAttribute("name", "포스트맨");
		return "hello";
	}
	
	
	@RequestMapping(value="/getParameter")
	public String getParameter(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value="/requestParam")
	public String requestParam(Model model, @RequestParam(value="name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value="/pathVariable/{name}")
	public String pathVariable(Model model, @PathVariable("name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value="/modelAttribute")
	public String modelAttribute(Model model, @ModelAttribute BoardItem boardItem) {
		model.addAttribute("name", boardItem.getAuthor());
		return "hello";
	}
	
	@RequestMapping(value="/requestBody1")
	public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
		model.addAttribute("name", obj.get("name"));
		return "hello";
	}
	
	@RequestMapping(value="/requestBody2")
	public String requestBody2(Model model, @RequestBody BoardItem boardItem) {
		model.addAttribute("name", boardItem.getAuthor());
		return "hello";
	}
	
	
}
