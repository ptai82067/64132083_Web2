package edu.taipp.TestSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChaoController {
@RequestMapping("/chao-em")
public String xin_chao() {
	return "welcome";
}
}
