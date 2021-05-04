package com.creed.interview.coding.demo.podcast;

import com.creed.interview.coding.demo.podcast.model.security.User;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import com.creed.interview.coding.demo.podcast.repository.PodcastRepository;
import com.creed.interview.coding.demo.podcast.repository.TopicRepository;
import com.creed.interview.coding.demo.podcast.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PodcastApplication implements  CommandLineRunner{
	@Autowired
	TopicRepository topicRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PodcastApplication.class, args);
	}

	@Override
	public void run(String... args){
		// Initialize Jackson mapper
		ObjectMapper mapper = new ObjectMapper();

		try {
			//Reading the file from the resources folder
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("\\sample-api-response.json");

			//Getting the JSON string from the inputStream
			String json = new BufferedReader(
					new InputStreamReader(inputStream)).lines().collect(Collectors.joining());

			Topic topic = mapper.readValue(json, Topic.class);

			List<Topic> topicDB = topicRepository.findAllByPageNumber(1);

			if(topicDB.isEmpty()){
				topicRepository.save(topic);
			}

			List<User> userList = userRepository.findAll();

			if(userList.isEmpty()){
				User user1 = new User();

				user1.setUserName("test");
				user1.setPassword("password");
				user1.setRoles("ROLE_USER");
				user1.setActive(true);

				userRepository.save(user1);

				User user2 = new User();

				user2.setUserName("admin");
				user2.setPassword("admin");
				user2.setRoles("ROLE_USER, ROLE_ADMIN");
				user2.setActive(true);

				userRepository.save(user2);

				User user3 = new User();

				user3.setUserName("support");
				user3.setPassword("support");
				user3.setRoles("ROLE_SUPPORT");
				user3.setActive(true);

				userRepository.save(user3);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
