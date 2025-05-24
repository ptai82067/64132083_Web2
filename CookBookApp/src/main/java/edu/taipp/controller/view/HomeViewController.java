package edu.taipp.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeViewController {
  @RequestMapping("/")
  public String home(){
    return "user/index";
  }
}
