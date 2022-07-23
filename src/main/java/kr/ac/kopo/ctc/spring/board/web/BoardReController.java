package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.service.BoardReService;
import kr.ac.kopo.ctc.spring.board.service.BoardService;

@Controller
public class BoardReController {
	
	@Autowired
	private BoardReService boardReService;
	
	@Autowired
	private BoardService boardServce;
	
	@RequestMapping(value = "/createReply/{id}")
	public String createRepluyItem(Model model, @PathVariable("id") int id) {
		model.addAttribute("boardId", id);
		return "createReply";
	}

}
