package com.creed.interview.coding.demo.podcast.model.podcast;

import com.creed.interview.coding.demo.podcast.model.extra.Extra;
import com.creed.interview.coding.demo.podcast.model.lookingFor.LookingFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
