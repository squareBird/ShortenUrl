package com.example.shortenurl.presentation;

import com.example.shortenurl.domain.ShortenUrl;
import lombok.Getter;

@Getter
public class ShortenUrlResponseDto {

    private String shortenUrl;
    private String url;
    private int views;

    public ShortenUrlResponseDto(ShortenUrl shortenUrl) {

        this.shortenUrl = shortenUrl.getShortenUrl();
        this.url = shortenUrl.getUrl();
        this.views = shortenUrl.getViews();

    }

}
