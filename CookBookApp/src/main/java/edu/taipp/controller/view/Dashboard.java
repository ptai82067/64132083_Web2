package edu.taipp.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Dashboard {
  @GetMapping
  public String dashboard(){
    return "admin/index";
  }
}
