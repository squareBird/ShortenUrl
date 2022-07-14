package com.example.shortenurl.domain;

public class ShortenUrlNotFoundException extends RuntimeException{

    public ShortenUrlNotFoundException(String msg) {
        super(msg);
    }

}
