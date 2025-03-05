package edu.taipp.SB_TruyenDuLieu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String input() {
		return "index";
	}
	
	@RequestMapping("/myInfo")
	public String displayInfor(@RequestParam("mssv") String mssv,
			@RequestParam("hoten") String hoTen, @RequestParam("namsinh") int namSinh,
			@RequestParam("gioitinh") String gioiTinh, Model m) {
		
		//đưa dữ liệu vào model
		m.addAttribute("mssv", mssv);
		m.addAttribute("hoTen", hoTen);
		m.addAttribute("namSinh", namSinh);
		m.addAttribute("gioiTinh", gioiTinh);

		return "info";
	}
}
