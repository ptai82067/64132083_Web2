package edu.taipp.SB_TongHopGK.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.taipp.SB_TongHopGK.model.SinhVien;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/about")
	public String aboutPage() {
		
		return "about";
	}
	
	@RequestMapping("/student-list")
	public String listPage(Model model) {
		List<SinhVien> listSV = new ArrayList<SinhVien>();
		listSV.add(new SinhVien("64132083", "Phạm Phước Tài", 8.5f));
	    listSV.add(new SinhVien("64132084", "Nguyễn Văn An", 7.8f));
	    listSV.add(new SinhVien("64132085", "Trần Thị B", 9.2f));
	    listSV.add(new SinhVien("64132086", "Lê Văn C", 6.5f));
	    listSV.add(new SinhVien("64132087", "Hoàng Minh D", 8.0f));
	    listSV.add(new SinhVien("64132088", "Vũ Thanh E", 7.3f));
	    listSV.add(new SinhVien("64132089", "Đặng Văn F", 8.9f));
	    listSV.add(new SinhVien("64132090", "Bùi Thị G", 7.1f));
	    listSV.add(new SinhVien("64132091", "Phan Văn H", 9.0f));
	    listSV.add(new SinhVien("64132092", "Ngô Thị I", 6.8f));
	    listSV.add(new SinhVien("64132093", "Đỗ Minh J", 7.5f));
	    listSV.add(new SinhVien("64132094", "Trịnh Văn K", 8.4f));
	    listSV.add(new SinhVien("64132095", "Dương Thị L", 6.9f));
	    listSV.add(new SinhVien("64132096", "Lâm Văn M", 8.2f));
	    listSV.add(new SinhVien("64132097", "Hà Minh N", 7.6f));
		
		model.addAttribute("listSV", listSV);
		return "students";
	}
	
	@RequestMapping("/add-new")
	public String addNewPage() {
		
		return "add_new";
	}
	
}
