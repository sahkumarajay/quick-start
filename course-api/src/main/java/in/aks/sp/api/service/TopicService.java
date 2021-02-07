package in.aks.sp.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import in.aks.sp.api.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic(1, "JDBC", "Advance Java Data base "), new Topic(2, "Java", "Core Java"),
					new Topic(3, "Servlet", "Web Application"), new Topic(4, "JSP", "For view part web application")));

	public List<Topic> getAllTopics() {

		return topics;
	}

	public Topic getTopicByID(Integer id) {

		return topics.stream().filter(top -> top.getId().equals(id)).findFirst().get();

	}

	public boolean addTopic(Topic topic) {
		boolean result = false;
		try {
			System.out.println("In addTopic Method " + topics);
			topics.add(topic);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public void updateTopicById(Topic topic, Integer id) {

		for (int i = 0; i < topics.size() ; i++) {
			Topic topicObj = topics.get(i);

			if (topicObj.getId().equals(id)) {

				topics.set(i, topic);
				System.out.println(topics);
				return;
			}
		}
	}

	public void deleteTopic(Integer id) {
		topics.removeIf(tp -> tp.getId().equals(id));
		
	}

}
