package edu.taipp.Frame_1.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taipp.Frame_1.model.SinhVien;

@Controller
@RequestMapping("admin/sinh-vien")
public class SinhVienController {
	private static final List<SinhVien> listSV = new ArrayList<SinhVien>();
	
	static {
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
    }
	@GetMapping
	public String Index(Model model) {
		
		
		model.addAttribute("listSV", listSV);
		
		return "admin/menu";
	}
	
	@GetMapping("/them-sv")
	public String createSV() {
		return "admin/ql_sinh_vien/add_sinh_vien";
	}
	
	@GetMapping("/add-sv")
	public String create(@RequestParam(name="MSSV", defaultValue = "", required = true) String MSSV,
						@RequestParam(name="hoTen", defaultValue = "", required = true) String hoTen,
						@RequestParam(name="diemTB", defaultValue = "", required = true) String diemTB,
						Model model) {
	    try {
	        float diem = Float.parseFloat(diemTB);
	        listSV.add(new SinhVien(MSSV, hoTen, diem));
	    } catch (NumberFormatException e) {
	        model.addAttribute("error", "Điểm trung bình không hợp lệ.");
	        return "admin/ql_sinh_vien/add_sinh_vien";
	    }
	    model.addAttribute("listSV", listSV);
	    return "redirect:/admin/sinh-vien";
		
	}
	
	
    @GetMapping("/delete/{mssv}")
    public String deleteSinhVien(@PathVariable String mssv) {
        listSV.removeIf(sv -> sv.getMSSV().equals(mssv));
        return "redirect:/admin/sinh-vien"; // Reload lại danh sách
    }

    @GetMapping("/edit/{mssv}")
    public String editSinhVien(@PathVariable String mssv, Model model) {
        for (SinhVien sv : listSV) {
            if (sv.getMSSV().equals(mssv)) {
                model.addAttribute("sv", sv);
                break;
            }
        }
        return "admin/ql_sinh_vien/edit_sinh_vien"; // Trả về trang chỉnh sửa
    }
    
    @PostMapping("/update")
    public String updateSinhVien(@RequestParam String mssv, 
                                 @RequestParam String hoTen, 
                                 @RequestParam float diemTB) {
        for (SinhVien sv : listSV) {
            if (sv.getMSSV().equals(mssv)) {
                sv.setHoTen(hoTen);
                sv.setDiemTB(diemTB);
                break;
            }
        }
        return "redirect:/admin/sinh-vien";
    }

}
