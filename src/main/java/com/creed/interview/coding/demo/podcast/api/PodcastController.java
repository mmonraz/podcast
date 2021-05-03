package com.creed.interview.coding.demo.podcast.api;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.creed.interview.coding.demo.podcast.model.topic.Topic;
import com.creed.interview.coding.demo.podcast.service.PodCastService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PodcastController {
    PodCastService podCastService;

    //Injecting the service using constructor injection - This is the best injection
    @Autowired
    public PodcastController(PodCastService podCastService) {
        this.podCastService = podCastService;
    }

    //Calling the web service
    @GetMapping("/best_podcasts")
    public List<Topic> getPodcast(@RequestParam(value = "genre_id", required = false) Integer genreId,
    @RequestParam(required = false) Integer page){

        /*
            Below code was intended when if we were allowing to send a list of genre_ids as comma separated value
            instead of a single value

            List<Integer> genreIdList = Stream.of(genreIds.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
          */


        return podCastService.getTopicPodCasts(genreId, page);
    }
}
