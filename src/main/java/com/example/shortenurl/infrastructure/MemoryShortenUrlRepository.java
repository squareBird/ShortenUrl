package com.example.shortenurl.infrastructure;

import com.example.shortenurl.domain.ShortenUrlRepository;
import com.example.shortenurl.domain.ShortenUrl;
import com.example.shortenurl.domain.ShortenUrlNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("memory")
public class MemoryShortenUrlRepository implements ShortenUrlRepository {

    private final Map<String, ShortenUrl> store = new HashMap<>();

    @Override
    public void save(ShortenUrl shortenUrl) {
        store.put(shortenUrl.getShortenUrl(), shortenUrl);
    }

    @Override
    public ShortenUrl findByShortenUrl(String kwd) {

        ShortenUrl shortenUrl = store.get(kwd);

        if(shortenUrl ==null)
            throw new ShortenUrlNotFoundException("해당 단축URL이 존재하지 않습니다.");

        shortenUrl.addViews();

        return shortenUrl;

    }

    @Override
    public List<ShortenUrl> showAll() {
        return store.values()
                .stream()
                .toList();
    }

}
