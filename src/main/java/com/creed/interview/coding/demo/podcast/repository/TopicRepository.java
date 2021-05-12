package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    //Retrieve the list of all topics having the given page number
    List<Topic> findAllByPageNumber(Integer page);

}
