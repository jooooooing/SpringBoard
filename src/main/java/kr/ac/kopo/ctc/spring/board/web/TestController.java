package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.TestItem;
import kr.ac.kopo.ctc.spring.board.repository.TestItemRepository;


@Controller
public class TestController {
	
	@Autowired
	private TestItemRepository testItemRepository;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public List<TestItem> list(Model model) {
		return testItemRepository.findAll();
	}

}
