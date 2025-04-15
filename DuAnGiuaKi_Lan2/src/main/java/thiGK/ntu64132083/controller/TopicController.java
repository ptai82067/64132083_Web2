package thiGK.ntu64132083.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132083.model.Topic;

@Controller
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
	// xem danh sách
	@GetMapping("/topic/all")
	public String list(Model model) {
		model.addAttribute("listTopic", listTopic);
		return "topic/list";
	}
	// thêm mới
	@GetMapping("/topic/new")
	public String addNewForm() {
		return"topic/add_new";
	}
	@PostMapping("/topic/new")
	public String addNew(@RequestParam String id,
            @RequestParam String topicName,
            @RequestParam String topicDescription,
            @RequestParam String supervisorId,
            @RequestParam String topicType,
            Model model) {
	
	listTopic.add(new Topic(id, topicName, topicDescription, supervisorId, topicType));
	
	return "redirect:/topic/all";
	}
	// xem
   @GetMapping("/topic/view/{id}")
   public String view(@PathVariable String id, Model model) {
       for (Topic topic : listTopic) {
           if (topic.getId().equals(id)) {
               model.addAttribute("tp", topic);
               break;
           }
       }
       return "topic/view"; // Trả về trang chỉnh sửa
   }
	// xóa
    @GetMapping("/topic/delete/{id}")
    public String delete(@PathVariable String id) {
        listTopic.removeIf(sv -> sv.getId().equals(id));
        return "redirect:/topic/all"; // Reload lại danh sách
    }
}
