package thiGK.ntu64132083.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132083.model.Student;
import thiGK.ntu64132083.model.Topic;

@Controller
public class StudentController {
	private static final List<Student> listStudent = new ArrayList<Student>();
	
	static {
		listStudent.add(new Student("S001", "Nguyen Van A", "G01"));
	    listStudent.add(new Student("S002", "Tran Thi B", "G02"));
	    listStudent.add(new Student("S003", "Le Van C", "G01"));
	    listStudent.add(new Student("S004", "Pham Thi D", "G03"));
	    listStudent.add(new Student("S005", "Hoang Van E", "G02"));
	    listStudent.add(new Student("S006", "Do Thi F", "G04"));
	    listStudent.add(new Student("S007", "Bui Van G", "G01"));
	    listStudent.add(new Student("S008", "Vo Thi H", "G03"));
	    listStudent.add(new Student("S009", "Dang Van I", "G04"));
	    listStudent.add(new Student("S010", "Phan Thi J", "G02"));
           
    }
	// xem danh sách
		@GetMapping("/student/all")
		public String list(Model model) {
			model.addAttribute("listStudent", listStudent);
			return "student/list";
		}
		// thêm mới
		@GetMapping("/student/new")
		public String addNewForm() {
			return"student/add_new";
		}
		@PostMapping("/student/new")
		public String addNew(@RequestParam String id, 
                @RequestParam String name, 
                @RequestParam String groupId,
	            Model model) {
			listStudent.add(new Student(id, name, groupId));
		return "redirect:/student/all";
		}
		// xem
		   @GetMapping("/student/view/{id}")
		   public String view(@PathVariable String id, Model model) {
		       for (Student student : listStudent) {
		           if (student.getId().equals(id)) {
		               model.addAttribute("sv", student);
		               break;
		           }
		       }
		       return "student/view"; // Trả về trang chỉnh sửa
		   }
			// xóa
		    @GetMapping("/student/delete/{id}")
		    public String delete(@PathVariable String id) {
		        listStudent.removeIf(sv -> sv.getId().equals(id));
		        return "redirect:/student/all"; // Reload lại danh sách
		    }
}
