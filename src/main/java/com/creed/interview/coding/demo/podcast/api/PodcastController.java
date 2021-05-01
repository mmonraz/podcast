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

@RestController
public class PodcastController {
    PodCastService podCastService;

    //Injecting the service using constructor injection - This is the best injection
    @Autowired
    public PodcastController(PodCastService podCastService) {
        this.podCastService = podCastService;
    }

    //Calling the web service
    @GetMapping("/best_podcasts/{id}")
    public Topic getPodcast(@PathVariable("id") Integer id, @RequestParam(value = "genre_id", required = false) Integer genreId,
    @RequestParam(required = false) Integer page, @RequestParam(required = false) String region, @RequestParam(value = "safe_mode", required = false) Integer safeMode){
        return podCastService.getTopicById(id);
    }
}
