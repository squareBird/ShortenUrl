package com.example.shortenurl.domain;

import com.example.shortenurl.service.ShortenUrlNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class MemoryRepository implements Repository {

    private final Map<String, ShortenUrlInfo> store = new HashMap<>();

    @Override
    public void save(ShortenUrlInfo shortenUrlInfo) {
        store.put(shortenUrlInfo.getShortenUrl(), shortenUrlInfo);
    }

    @Override
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

    @Override
    public ShortenUrlInfo findByShortenUrl(String shortenUrl) {

        ShortenUrlInfo shortenUrlInfoEntity = store.get(shortenUrl);

        if(shortenUrlInfoEntity ==null)
            throw new ShortenUrlNotFoundException("해당 단축URL이 존재하지 않습니다.");

        addViews(shortenUrlInfoEntity);

        return shortenUrlInfoEntity;

    }

    @Override
    public List<ShortenUrlInfo> showAll() {
        return store.values()
                .stream()
                .toList();
    }

    @Override
    public void addViews(ShortenUrlInfo shortenUrlInfo) {
        shortenUrlInfo.setViews(shortenUrlInfo.getViews()+1);
    }

}
