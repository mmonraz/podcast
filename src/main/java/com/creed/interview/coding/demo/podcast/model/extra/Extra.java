package com.creed.interview.coding.demo.podcast.model.extra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Extra {

    @Column(name = "twitter_handle")
    @JsonProperty("twitter_handle")
    private String twitterHandle;

    @Column(name = "facebook_handle")
    @JsonProperty("facebook_handle")
    private String facebookHandle;

    @Column(name = "instagram_handle")
    @JsonProperty("instagram_handle")
    private String instragramHandle;

    @Column(name = "wechat_handle")
    @JsonProperty("wechat_handle")
    private String wechatHandle;

    @Column(name = "patreon_handle")
    @JsonProperty("patreon_handle")
    private String patreonHandle;

    @Column(name = "youtube_url")
    @JsonProperty("youtube_url")
    private String youtubeUrl;

    @Column(name = "linkedin_url")
    @JsonProperty("linkedin_url")
    private String linkedinUrl;

    @Column(name = "spotify_url")
    @JsonProperty("spotify_url")
    private String spotifyUrl;

    @Column(name = "google_url")
    @JsonProperty("google_url")
    private String googleUrl;

    private String url1;
    private String url2;
    private String url3;
}
