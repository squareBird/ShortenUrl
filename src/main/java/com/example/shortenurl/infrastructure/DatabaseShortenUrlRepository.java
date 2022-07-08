package com.example.shortenurl.infrastructure;

import com.example.shortenurl.domain.ShortenUrl;
import com.example.shortenurl.domain.ShortenUrlRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("database")
public class DatabaseShortenUrlRepository implements ShortenUrlRepository {


    @Override
    public void save(ShortenUrl shortenUrl) {

    }

    @Override
    public ShortenUrl findByShortenUrl(String kwd) {
        return null;
    }

    @Override
    public List<ShortenUrl> showAll() {
        return null;
    }
}
