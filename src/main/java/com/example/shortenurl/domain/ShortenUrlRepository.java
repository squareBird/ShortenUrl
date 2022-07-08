package com.example.shortenurl.domain;

import java.util.List;

public interface ShortenUrlRepository {

    void save(ShortenUrl shortenUrl);

    ShortenUrl findByShortenUrl(String kwd);

    List<ShortenUrl> showAll();

}
