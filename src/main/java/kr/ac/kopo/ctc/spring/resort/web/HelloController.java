package kr.ac.kopo.ctc.spring.resort.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello")
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "이주현");
		return "hello";
	}
	

}
