package com.creed.interview.coding.demo.podcast.model.topic;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "topic")
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
    @Where(clause = "")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(int previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public int getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(int nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }
}
