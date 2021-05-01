package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;

import java.util.List;

public interface PodCastService {
    Topic getTopicPodCasts(Integer id, Integer genreId, Integer page, String region, Integer safeMode);

    Topic getTopicById(Integer id);
}
