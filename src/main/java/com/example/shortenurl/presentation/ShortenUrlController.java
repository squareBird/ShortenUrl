package com.example.shortenurl.presentation;

import com.example.shortenurl.application.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ShortenUrlController {

    private final ShortenUrlService shortenUrlService;

    @Autowired
    ShortenUrlController(ShortenUrlService shortenUrlService) {
        this.shortenUrlService = shortenUrlService;
    }

    @RequestMapping(value = "/shortenUrl", method = RequestMethod.POST)
    ResponseEntity generateShortenUrl(@RequestBody ShortenUrlRequestDto shortenUrlRequestDTO) {

        ShortenUrlResponseDto shortenUrlResponseDto = shortenUrlService.generateShortenUrl(shortenUrlRequestDTO);

        return new ResponseEntity(shortenUrlResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/shortenUrl/{shortenUrl}", method = RequestMethod.GET)
    ResponseEntity redirectShortenUrl(@PathVariable String shortenUrl) throws URISyntaxException {

        String uri = shortenUrlService.findByShortUrl(shortenUrl).getUrl();

        URI redirectURI = new URI(uri);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectURI);

        return new ResponseEntity(httpHeaders, HttpStatus.TEMPORARY_REDIRECT);

    }

    @RequestMapping(value = "/shortenUrl/all", method = RequestMethod.GET)
    ResponseEntity showAll() {

        return new ResponseEntity(shortenUrlService.showAll(), HttpStatus.OK);

    }
}
