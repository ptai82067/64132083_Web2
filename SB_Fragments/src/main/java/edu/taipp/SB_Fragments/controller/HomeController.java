package edu.taipp.SB_Fragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}
}
