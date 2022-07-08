package com.example.shortenurl.application;

import com.example.shortenurl.presentation.ShortenUrlResponseDto;
import com.example.shortenurl.presentation.ShortenUrlRequestDto;
import com.example.shortenurl.domain.ShortenUrlRepository;
import com.example.shortenurl.domain.ShortenUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShortenUrlService {

    private final ShortenUrlRepository shortenUrlRepository;

    @Autowired
    ShortenUrlService(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public ShortenUrlResponseDto generateShortenUrl(ShortenUrlRequestDto shortenUrlRequestDTO) {

        ShortenUrl shortenUrl = new ShortenUrl(shortenUrlRequestDTO.getUrl());
        shortenUrlRepository.save(shortenUrl);

        return new ShortenUrlResponseDto(shortenUrl);

    }

    public ShortenUrlResponseDto findByShortUrl(String kwd) {

        ShortenUrl shortenUrl = shortenUrlRepository.findByShortenUrl(kwd);

        return new ShortenUrlResponseDto(shortenUrl);

    }

    public List<ShortenUrlResponseDto> showAll() {

        return shortenUrlRepository.showAll()
                .stream()
                .map(shortenUrl -> new ShortenUrlResponseDto(shortenUrl))
                .toList();

    }

}
