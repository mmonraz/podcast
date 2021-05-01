package com.creed.interview.coding.demo.podcast.model.extra;

import com.creed.interview.coding.demo.podcast.model.podcast.Podcast;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
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

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getFacebookHandle() {
        return facebookHandle;
    }

    public void setFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
    }

    public String getInstragramHandle() {
        return instragramHandle;
    }

    public void setInstragramHandle(String instragramHandle) {
        this.instragramHandle = instragramHandle;
    }

    public String getWechatHandle() {
        return wechatHandle;
    }

    public void setWechatHandle(String wechatHandle) {
        this.wechatHandle = wechatHandle;
    }

    public String getPatreonHandle() {
        return patreonHandle;
    }

    public void setPatreonHandle(String patreonHandle) {
        this.patreonHandle = patreonHandle;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
}
