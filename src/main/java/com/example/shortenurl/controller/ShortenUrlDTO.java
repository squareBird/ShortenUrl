package com.example.shortenurl.controller;

import com.example.shortenurl.domain.ShortenUrlInfo;
import lombok.Getter;

@Getter
public class ShortenUrlDTO {

    private String shortenUrl;
    private String url;
    private int views;

    public ShortenUrlDTO(ShortenUrlInfo shortenUrlInfo) {

        this.shortenUrl = shortenUrlInfo.getShortenUrl();
        this.url = shortenUrlInfo.getUrl();
        this.views = shortenUrlInfo.getViews();

    }

}
