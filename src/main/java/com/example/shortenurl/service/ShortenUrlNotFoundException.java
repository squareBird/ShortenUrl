package com.example.shortenurl.service;

public class ShortenUrlNotFoundException extends RuntimeException{

    public ShortenUrlNotFoundException(String msg) {
        super(msg);
    }

}
