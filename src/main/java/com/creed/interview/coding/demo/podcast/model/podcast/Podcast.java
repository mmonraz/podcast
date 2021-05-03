package com.creed.interview.coding.demo.podcast.model.podcast;

import com.creed.interview.coding.demo.podcast.model.extra.Extra;
import com.creed.interview.coding.demo.podcast.model.lookingFor.LookingFor;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "podcast", uniqueConstraints = { @UniqueConstraint(columnNames = { "id"})})
public class Podcast {
    @Id
    private String id;
    private String title;
    private String publisher;
    private String image;
    private String thumbnail;

    @Column(name = "listennotes_url")
    @JsonProperty("listennotes_url")
    private String listennotesUrl;

    @Column(name = "total_episodes")
    @JsonProperty("total_episodes")
    private String totalEpisodes;

    @Column(name = "explicit_content")
    @JsonProperty("explicit_content")
    private boolean explicitContent;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "itunes_id")
    @JsonProperty("itunes_id")
    private Integer itunesId;

    private String rss;

    @Column(name = "latest_pub_date_ms")
    @JsonProperty("latest_pub_date_ms")
    private Long latestPubDateMs;

    @Column(name = "earliest_pub_date_ms")
    @JsonProperty("earliest_pub_date_ms")
    private Long earliestPubDateMs;

    private String language;
    private String country;
    private String website;

    private Extra extra;

    @Column(name = "is_claimed")
    @JsonProperty("is_claimed")
    private boolean isClaimed;
    private String email;
    private String type;

    @Column(name = "looking_for")
    @JsonProperty("looking_for")
    private LookingFor lookingFor;

    @ElementCollection
    @CollectionTable(name = "podcast_genreIds", joinColumns = @JoinColumn(name = "podcast_id"))
    @Column(name = "genre_ids")
    @JsonProperty("genre_ids")
    private List<Integer> genreIds = new ArrayList<>();

    public Podcast(String id, String title, String publisher, String image, String thumbnail, String listennotesUrl,
                   String totalEpisodes, boolean explicitContent, String description, Integer itunesId, String rss,
                   Long latestPubDateMs, Long earliestPubDateMs, String language, String country, String website,
                   Extra extra, boolean isClaimed, String email, String type, LookingFor lookingFor) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.image = image;
        this.thumbnail = thumbnail;
        this.listennotesUrl = listennotesUrl;
        this.totalEpisodes = totalEpisodes;
        this.explicitContent = explicitContent;
        this.description = description;
        this.itunesId = itunesId;
        this.rss = rss;
        this.latestPubDateMs = latestPubDateMs;
        this.earliestPubDateMs = earliestPubDateMs;
        this.language = language;
        this.country = country;
        this.website = website;
        this.extra = extra;
        this.isClaimed = isClaimed;
        this.email = email;
        this.type = type;
        this.lookingFor = lookingFor;
    }

    public Podcast() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Podcast)) return false;
        Podcast podcast = (Podcast) o;
        return id.equals(podcast.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(String totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public Long getLatestPubDateMs() {
        return latestPubDateMs;
    }

    public void setLatestPubDateMs(Long latestPubDateMs) {
        this.latestPubDateMs = latestPubDateMs;
    }

    public Long getEarliestPubDateMs() {
        return earliestPubDateMs;
    }

    public void setEarliestPubDateMs(Long earliestPubDateMs) {
        this.earliestPubDateMs = earliestPubDateMs;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public boolean isClaimed() {
        return isClaimed;
    }

    public void setClaimed(boolean claimed) {
        isClaimed = claimed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LookingFor getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(LookingFor lookingFor) {
        this.lookingFor = lookingFor;
    }

    public boolean isExplicitContent() {
        return explicitContent;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
}
