package in.aks.sp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.aks.sp.api.model.Topic;
import in.aks.sp.api.service.TopicService;

/**
 * @author ajay
 *
 */
@RestController
@RequestMapping("/aks")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public List<Topic> getAllTopics()

	{
		return topicService.getAllTopics();

	}

	@RequestMapping(method = RequestMethod.GET, path = "/topic")
	public Topic getTopicById(@RequestParam("id") Integer id) {

		return topicService.getTopicByID(id);

	}

	@PostMapping("/topics")
	public String saveTopics(@RequestBody List<Topic> topics) {

		return "Saved Successfully";

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public String updateTopic(@RequestBody Topic topic ,@PathVariable Integer id) {
		topicService.updateTopicById(topic,id);
		return "Updated Successfully";
	}

	@DeleteMapping("topic/{id}")
	public String deleteTopic(@PathVariable Integer id) {
		topicService.deleteTopic(id);
		return "deleted Successfully";
	}

	@RequestMapping(path = "/topic" ,method = RequestMethod.POST)
	public  String addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		return "Added successfully";
	}

}
