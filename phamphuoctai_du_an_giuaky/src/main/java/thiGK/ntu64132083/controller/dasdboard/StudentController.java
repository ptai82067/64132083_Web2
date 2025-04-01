package thiGK.ntu64132083.controller.dasdboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132083.model.Student;
import thiGK.ntu64132083.model.Topic;

@Controller
@RequestMapping("dasdboard/student")
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
	@GetMapping
	public String Index(Model model) {
		
		
		model.addAttribute("listStudent", listStudent);
		
		return "dasdboard/student";
	}
	
	@GetMapping("/new")
	public String createSV() {
		return "dasdboard/ql_student/add_student";
	}
	
	@PostMapping("/add-new")
	public String addStudent(@RequestParam String id, 
	                         @RequestParam String name, 
	                         @RequestParam String groupId, 
	                         Model model) {
	    listStudent.add(new Student(id, name, groupId));
	    model.addAttribute("listStudent", listStudent);
	    return "redirect:/dasdboard/student";
	}
	
	 @GetMapping("/view/{id}")
	   public String editTopic(@PathVariable String id, Model model) {
	       for (Student st : listStudent) {
	           if (st.getId().equals(id)) {
	               model.addAttribute("st", st);
	               break;
	           }
	       }
	       return "dasdboard/ql_student/view_student"; // Trả về trang chỉnh sửa
	   }
	
	 @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable String id) {
	        listStudent.removeIf(sv -> sv.getId().equals(id));
	        return "redirect:/dasdboard/student"; // Reload lại danh sách
	    }

	
}
