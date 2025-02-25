package taipp.controller;
import org.springframework.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("say-hi")
	public String SayHello() {
		
		return "chao";
	}
}
