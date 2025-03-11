package edu.taipp.HelloSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/chao")
	public String xin_chao(ModelMap m) {
		m.addAttribute("tb", "Dữ liệu thông báo xin chào");
		return "welcome";
	}
	
	@RequestMapping("/you")
	public String hi() {
		return "name";
	}
}
