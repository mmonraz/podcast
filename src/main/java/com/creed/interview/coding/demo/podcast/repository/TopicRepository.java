package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    //Retrieve the list of all topics having the given page number
    List<Topic> findAllByPageNumber(Integer page);

}
