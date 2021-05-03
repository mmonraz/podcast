package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import com.creed.interview.coding.demo.podcast.repository.PodcastRepository;
import com.creed.interview.coding.demo.podcast.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PodcastServiceImpl implements  PodCastService{

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getTopicPodCasts(Integer genreId, Integer page) {
        List<Topic> topicList = topicRepository.findAllByPageNumber(page);

        /*If we only dealing with a single topic we can filter its podcast by using the below JPA repository method
         List<Podcast> filteredPodCastList = podcastRepository.findByGenreIdsIn(genreIds);

         If the condition to filter the list of podcasts from the Topic were static then might have use @Filter
         Also I tried to use @Filter but I was not able get hold of the details table

         Since we are getting a list of Topics that corresponds to the page number sent as parameter
         We need to check each topic and filter their corresponding podcast list by comma separated list of
         genre ids
         */
        for(Topic topic: topicList){
            List<Podcast> podcastList = new ArrayList<>();
            for(Podcast podcast: topic.getPodcasts()){
                if(podcast.getGenreIds().contains(genreId)){
                    podcastList.add(podcast);
                }
            }

            topic.setPodcasts(podcastList);

        }

        return topicList;
    }

    @Override
    public List<Topic> getTopicByPageNumber(Integer page) {
        return topicRepository.findAllByPageNumber(page);
    }


}
