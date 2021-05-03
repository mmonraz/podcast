package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PodcastRepository extends JpaRepository<Podcast, String> {
    List<Podcast> findByGenreIdsIn(List<Integer> genreIds);

}
