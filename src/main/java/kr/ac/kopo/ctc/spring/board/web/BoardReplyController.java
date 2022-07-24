package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.service.BoardReplyService;

@Controller
@RequestMapping(value = "/boardReply")
public class BoardReplyController {
	
	@Autowired
	private BoardReplyService boardReplyService;


}
