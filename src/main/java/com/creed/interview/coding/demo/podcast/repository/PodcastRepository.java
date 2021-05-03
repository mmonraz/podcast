package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends JpaRepository<Topic, Integer> {
    Topic findTopicByIdAndPodcastsGenreIds(@Param("id") Integer id, @Param("genreId") Integer genreId);
    Topic findTopicById(Integer id);
}
