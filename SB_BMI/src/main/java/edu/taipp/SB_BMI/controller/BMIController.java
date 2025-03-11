package edu.taipp.SB_BMI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {
	@RequestMapping("/")
	public String BMI() {
		return "index";
	}
	@RequestMapping("/bmi-ketqua")
	public String bmi_KetQua(@RequestParam("weight") float weight,
								@RequestParam("height") float height, Model model) {
		 // Tính chỉ số BMI
	    float bmi = weight / (height * height);
	    
	    // Xác định tình trạng cơ thể
	    String category;
	    if (bmi < 18.5f) {
	        category = "Gầy";
	    } else if (bmi < 24.9f) {
	        category = "Bình thường";
	    } else if (bmi < 29.9f) {
	        category = "Thừa cân";
	    } else {
	        category = "Béo phì";
	    }
	    
	    // Truyền kết quả qua Model
	    model.addAttribute("bmi", bmi);
	    model.addAttribute("category", category);
		
		return "bmi_view";
	}
}
