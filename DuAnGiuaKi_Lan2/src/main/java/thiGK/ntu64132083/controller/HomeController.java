package thiGK.ntu64132083.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String Index() {	
		return "index";
	}
	

}
