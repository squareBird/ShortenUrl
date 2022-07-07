package com.example.shortenurl.service;

import com.example.shortenurl.controller.ShortenUrlDTO;
import com.example.shortenurl.controller.UserInputDTO;
import com.example.shortenurl.domain.Repository;
import com.example.shortenurl.domain.ShortenUrlInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShortenUrlServiceImpl implements ShortenUrlService {

    private final Repository repository;

    @Autowired
    ShortenUrlServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public ShortenUrlDTO generateShortenUrl(UserInputDTO userInputDTO) {

        String shortenUrl = repository.generateUrl();
        ShortenUrlInfo shortenUrlInfoEntity = new ShortenUrlInfo(shortenUrl, userInputDTO.getUrl());
        repository.save(shortenUrlInfoEntity);

        return new ShortenUrlDTO(shortenUrlInfoEntity);

    }

    @Override
    public ShortenUrlDTO findByShortUrl(String shortenUrl) {

        ShortenUrlInfo shortenUrlInfoEntity = repository.findByShortenUrl(shortenUrl);

        return new ShortenUrlDTO(shortenUrlInfoEntity);

    }

    @Override
    public List<ShortenUrlDTO> showAll() {

        return repository.showAll()
                .stream()
                .map(shortenUrlInfo -> new ShortenUrlDTO(shortenUrlInfo))
                .toList();

    }

}
