package com.example.shortenurl.presentation;

import com.example.shortenurl.domain.ShortenUrl;
import lombok.Getter;

import java.util.Optional;

@Getter
public class ShortenUrlResponseDto {

    private String shortenUrl;
    private String url;
    private int views;

    public ShortenUrlResponseDto(Optional<ShortenUrl> shortenUrl) {

        this.shortenUrl = shortenUrl.get().getShortenUrl();
        this.url = shortenUrl.get().getUrl();
        this.views = shortenUrl.get().getViews();

    }

}
