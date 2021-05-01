package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import com.creed.interview.coding.demo.podcast.repository.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodcastServiceImpl implements  PodCastService{

    private PodcastRepository podcastRepository;

    @Autowired
    public PodcastServiceImpl(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @Override
    public Topic getTopicPodCasts(Integer id, Integer genreId, Integer page, String region, Integer safeMode) {
        return podcastRepository.findTopicByIdAndPodcastsGenreIds(id, genreId);
    }

    @Override
    public Topic getTopicById(Integer id) {
        return podcastRepository.findTopicById(id);
    }


}
