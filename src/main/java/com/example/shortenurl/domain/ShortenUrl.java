package com.example.shortenurl.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Getter
@Entity
public class ShortenUrl {

    @Id
    private String shortenUrl;
    private String url;
    private int views;

    public ShortenUrl() {

    }

    public ShortenUrl(String url) {
        this.shortenUrl = generateUrl();
        this.url = url;
        this.views = 0;
    }

    public ShortenUrl(String shortenUrl, String url, int views) {
        this.shortenUrl = shortenUrl;
        this.url = url;
        this.views = views;
    }

    public String generateUrl() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }

    public void addViews() {
        this.views++;
    }

}
