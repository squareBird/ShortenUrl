package com.example.shortenurl.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenUrlInfo {

    private String shortenUrl;
    private String url;
    private int views;

    public ShortenUrlInfo(String shortenUrl, String url) {
        this.shortenUrl = shortenUrl;
        this.url = url;
        this.views = 0;
    }

}
