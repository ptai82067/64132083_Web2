package thiGK.ntu64132083.controller.dasdboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasdboardController {
	@RequestMapping("/dasdboard")
	public String Index() {
		return "dasdboard/index";
	}
}
