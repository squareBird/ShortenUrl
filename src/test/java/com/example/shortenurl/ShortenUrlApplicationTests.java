package com.example.shortenurl;

import com.example.shortenurl.application.ShortenUrlService;
import com.example.shortenurl.domain.ShortenUrl;
import com.example.shortenurl.domain.ShortenUrlRepository;
import com.example.shortenurl.infrastructure.DatabaseShortenUrlRepository;
import com.example.shortenurl.infrastructure.MemoryShortenUrlRepository;
import com.example.shortenurl.presentation.ShortenUrlController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Transactional
class ShortenUrlApplicationTests {

    @MockBean
    ShortenUrlService shortenUrlService;

    @MockBean
    ShortenUrlController shortenUrlController;

    @MockBean
    MemoryShortenUrlRepository shortenUrlRepository;
//    DatabaseShortenUrlRepository shortenUrlRepository;

    @Test
    void saveTest() {
        ShortenUrl shortenUrl = new ShortenUrl("www.naver.com");
        shortenUrlRepository.save(shortenUrl);
    }

    @Test
    void findByUrl() {
        ShortenUrl shortenUrl = new ShortenUrl("www.naver.com");
        String kwd = shortenUrl.getShortenUrl();
        shortenUrlRepository.save(shortenUrl);
        Optional<ShortenUrl> byShortenUrl = shortenUrlRepository.findByShortenUrl(kwd);

        System.out.println(byShortenUrl.get().getShortenUrl());

    }


}
