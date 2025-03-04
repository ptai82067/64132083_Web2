package edu.taipp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("say-hi")
	public String sayHello() {
		return "chao";
	}
}
