package com.example.shortenurl.presentation;

import lombok.Getter;

@Getter
public class ShortenUrlRequestDto {

    String url;

    public ShortenUrlRequestDto() {

    }

    public ShortenUrlRequestDto(String url) {
        this.url = url;
    }

}
