package edu.taipp.SB_TongHopGK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/about")
	public String aboutPage() {
		
		return "about";
	}
	
	@RequestMapping("/student-list")
	public String listPage() {
		
		return "students";
	}
	
	@RequestMapping("/add-new")
	public String addNewPage() {
		
		return "add_new";
	}
	
}
