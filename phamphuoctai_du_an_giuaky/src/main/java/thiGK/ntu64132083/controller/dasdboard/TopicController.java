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

import thiGK.ntu64132083.model.Topic;

@Controller
@RequestMapping("dasdboard/topic")
public class TopicController {
	private static final List<Topic> listTopic = new ArrayList<Topic>();
	
	static {
		listTopic.add(new Topic("T01", "AI in Healthcare", "Using AI for medical diagnosis", "S001", "Research"));
        listTopic.add(new Topic("T02", "Blockchain Security", "Enhancing security with blockchain", "S002", "Research"));
        listTopic.add(new Topic("T03", "IoT in Smart Cities", "Applications of IoT in urban planning", "S003", "Development"));
        listTopic.add(new Topic("T04", "Autonomous Vehicles", "Developing self-driving car technologies", "S004", "Research"));
        listTopic.add(new Topic("T05", "Cybersecurity Threats", "Analysis of modern cybersecurity threats", "S005", "Research"));
        listTopic.add(new Topic("T06", "Cloud Computing", "Exploring cloud architecture and services", "S006", "Development"));
        listTopic.add(new Topic("T07", "Big Data Analytics", "Using big data for business intelligence", "S007", "Research"));
        listTopic.add(new Topic("T08", "Machine Learning Applications", "Implementing ML in different industries", "S008", "Development"));
        listTopic.add(new Topic("T09", "Quantum Computing", "Investigating the future of quantum computing", "S009", "Research"));
        listTopic.add(new Topic("T10", "Edge Computing", "Optimizing processing at the edge of networks", "S010", "Development"));
       
    }
	@GetMapping
	public String Index(Model model) {
		
		
		model.addAttribute("listTopic", listTopic);
		
		return "dasdboard/topic";
	}
	
	@GetMapping("/new")
	public String createSV() {
		return "dasdboard/ql_topic/add_topic";
	}
	
	 @PostMapping("/add-new")
	    public String create(@RequestParam String id,
	                         @RequestParam String topicName,
	                         @RequestParam String topicDescription,
	                         @RequestParam String supervisorId,
	                         @RequestParam String topicType,
	                         Model model) {
	        try {
	            listTopic.add(new Topic(id, topicName, topicDescription, supervisorId, topicType));
	        } catch (Exception e) {
	            model.addAttribute("error", "Invalid input. Please check your data.");
	            return "dashboard/ql_topic/add_topic";
	        }
	        return "redirect:/dashboard/topic";
	    }

	
	
//    @GetMapping("/delete/{mssv}")
//    public String deleteTopic(@PathVariable String mssv) {
//        listTopic.removeIf(sv -> sv.getMSSV().equals(mssv));
//        return "redirect:/dasdboard/sinh-vien"; // Reload lại danh sách
//    }

//    @GetMapping("/edit/{mssv}")
//    public String editTopic(@PathVariable String mssv, Model model) {
//        for (Topic sv : listTopic) {
//            if (sv.getMSSV().equals(mssv)) {
//                model.addAttribute("sv", sv);
//                break;
//            }
//        }
//        return "dasdboard/ql_topic/edit_sinh_vien"; // Trả về trang chỉnh sửa
//    }
//    
//    @PostMapping("/update")
//    public String updateTopic(@RequestParam String mssv, 
//                                 @RequestParam String hoTen, 
//                                 @RequestParam float diemTB) {
//        for (Topic sv : listTopic) {
//            if (sv.getMSSV().equals(mssv)) {
//                sv.setHoTen(hoTen);
//                sv.setDiemTB(diemTB);
//                break;
//            }
//        }
//        return "redirect:/dasdboard/sinh-vien";
//    }

}
