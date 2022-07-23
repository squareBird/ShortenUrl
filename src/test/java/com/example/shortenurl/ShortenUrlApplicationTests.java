package com.example.shortenurl;

import com.example.shortenurl.application.ShortenUrlService;
import com.example.shortenurl.domain.ShortenUrl;
import com.example.shortenurl.domain.ShortenUrlRepository;
import com.example.shortenurl.presentation.ShortenUrlRequestDto;
import com.example.shortenurl.presentation.ShortenUrlResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ShortenUrlApplicationTests {

    @Mock
    private ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    private ShortenUrlService shortenUrlService;

    @Test
    public void save() {
        // Given
        String ORIGIN_URL = "https://www.naver.com";

        ShortenUrlRequestDto shortenUrlRequestDto = new ShortenUrlRequestDto();
        shortenUrlService.generateShortenUrl(shortenUrlRequestDto);

        // when
        when(shortenUrlRepository.findByShortenUrl(any())).thenReturn(Optional.of(new ShortenUrl(ORIGIN_URL, "1q2w", 0)));
        ShortenUrlResponseDto shortenUrlResponseDto = shortenUrlService.findByShortUrl("ddd");

        // then
        assertThat(shortenUrlResponseDto.getShortenUrl()).isEqualTo(ORIGIN_URL);
    }

}
