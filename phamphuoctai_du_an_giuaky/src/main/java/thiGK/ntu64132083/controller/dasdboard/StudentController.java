package thiGK.ntu64132083.controller.dasdboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
