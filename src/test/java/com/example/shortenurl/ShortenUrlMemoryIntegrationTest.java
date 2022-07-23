package com.example.shortenurl;

import com.example.shortenurl.application.ShortenUrlService;
import com.example.shortenurl.domain.ShortenUrlRepository;
import com.example.shortenurl.presentation.ShortenUrlRequestDto;
import com.example.shortenurl.presentation.ShortenUrlResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Profile("test")
public class ShortenUrlMemoryIntegrationTest {

    @Autowired ShortenUrlService shortenUrlService;
    @Autowired ShortenUrlRepository ShortenUrlRepository;

    @Test
    void ShortenUrl을_단축하고_조회하면_원본URL이_조회된다() {

        // given
        String URL = "www.naver.com";
        ShortenUrlRequestDto shortenUrlRequestDto = new ShortenUrlRequestDto(URL);

        // when
        ShortenUrlResponseDto shortenUrlResponseDto = shortenUrlService.generateShortenUrl(shortenUrlRequestDto);

        // then
        assertThat(shortenUrlRequestDto.getUrl()).isEqualTo(shortenUrlResponseDto.getUrl());


    }

    @Test
    void ShortenUrl_사용시_조회수가_늘어난다() {

        // given
        String URL = "www.naver.com";
        ShortenUrlRequestDto shortenUrlRequestDto = new ShortenUrlRequestDto(URL);
        ShortenUrlResponseDto shortenUrlResponseDto = shortenUrlService.generateShortenUrl(shortenUrlRequestDto);
        String shortenUrl = shortenUrlResponseDto.getShortenUrl();

        // when
        ShortenUrlResponseDto result = shortenUrlService.findByShortUrl(shortenUrl);

        // then
        assertThat(result.getViews()).isEqualTo(1);

    }

}
