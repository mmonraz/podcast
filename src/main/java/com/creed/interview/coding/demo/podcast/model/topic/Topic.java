package com.creed.interview.coding.demo.podcast.model.topic;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "parent_id")
    @JsonProperty("parent_id")
    private int parentId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Podcast.class)
    @JoinTable(name = "Topic_Podcast", joinColumns = @JoinColumn(name = "Topic_id"), inverseJoinColumns = @JoinColumn(name = "Podcast_id"))
    @JsonProperty("podcasts")
    private List<Podcast> podcasts;

    private int total;

    @Column(name = "has_next")
    @JsonProperty("has_next")
    private boolean hasNext;

    @Column(name = "has_previous")
    @JsonProperty("has_previous")
    private boolean hasPrevious;

    @Column(name = "page_number")
    @JsonProperty("page_number")
    private int pageNumber;

    @Column(name = "previous_page_number")
    @JsonProperty("previous_page_number")
    private int previousPageNumber;

    @Column(name = "next_page_number")
    @JsonProperty("next_page_number")
    private int nextPageNumber;

    @Column(name = "listennotes_url")
    @JsonProperty("listennotes_url")
    private String listennotesUrl;
}
