package edu.taipp.SB_TruyenDuLieu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taipp.SB_TruyenDuLieu.model.SinhVien;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String input() {
		return "index";
	}
	
	@RequestMapping("/dang-nhap")
	public String dangNhap() {
		return "dangnhap";
	}
	
	@RequestMapping("/xac-thuc")
	public String xacThuc(@RequestParam(name="ID", defaultValue = "", required = true) String id,
							@RequestParam(name="password", defaultValue = "", required = true) String password,
							Model model) {
		if(id.equals("ABC")) {
			if(password.equals("XYZ") ) {
				return "home";
			}else {
				model.addAttribute("check", "Mật khẩu không đúng");
			}
		}else {
			model.addAttribute("check","Tài khoản không đúng");
		}
		return "dangnhap";
	}
	
	@RequestMapping("/object")
	public String truyenDoiTuong(ModelMap m) {
		SinhVien sv1 = new SinhVien("64132083", "Phạm Phước Tài", 2004);
		m.addAttribute("sv",sv1);
		return "object_view";
	}
	
	@RequestMapping("/list")
	public String truyenDanhSach(Model m) {
		List<SinhVien> listSV = new ArrayList<>();
		listSV.add(new SinhVien("64132083", "Phạm Phước Tài", 2004));
        listSV.add(new SinhVien("64132084", "Nguyễn Văn An", 2003));
        listSV.add(new SinhVien("64132085", "Trần Thị B", 2002));
        listSV.add(new SinhVien("64132086", "Lê Văn C", 2004));
        listSV.add(new SinhVien("64132087", "Hoàng Thị D", 2003));
        listSV.add(new SinhVien("64132088", "Phan Văn E", 2002));
        listSV.add(new SinhVien("64132089", "Đỗ Thị F", 2004));
        listSV.add(new SinhVien("64132090", "Bùi Văn G", 2003));
        listSV.add(new SinhVien("64132091", "Võ Thị H", 2002));
        listSV.add(new SinhVien("64132092", "Lý Văn I", 2004));
        m.addAttribute("listSV",listSV);
		return "list_view";
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
