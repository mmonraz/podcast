package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;

import java.util.List;

public interface PodCastService {
    List<Topic> getTopicPodCasts(Integer genreId, Integer page);

    List<Topic> getTopicByPageNumber(Integer page);
}
