package com.example.shortenurl.domain;

import java.util.List;
import java.util.Optional;

public interface ShortenUrlRepository {

    void save(ShortenUrl shortenUrl);

    Optional<ShortenUrl> findByShortenUrl(String kwd);

    List<ShortenUrl> showAll();

}
