package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findAllByPageNumber(Integer id);

}
