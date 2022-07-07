package com.example.shortenurl.domain;

import java.util.List;

public interface Repository {

    void save(ShortenUrlInfo shortenUrlInfo);

    String generateUrl();

    ShortenUrlInfo findByShortenUrl(String shortenUrl);

    List<ShortenUrlInfo> showAll();

    void addViews(ShortenUrlInfo shortenUrlInfo);

}
