package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends JpaRepository<Topic, Integer> {
    Topic findTopicByIdAndPodcastsGenreIds(Integer id, Integer genreId);
    Topic findTopicById(Integer id);
}
