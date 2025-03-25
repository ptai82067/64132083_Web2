package edu.taipp.Frame_SP.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String Index() {
		return "admin/index";
	}
}
