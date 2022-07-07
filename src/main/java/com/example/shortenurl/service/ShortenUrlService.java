package com.example.shortenurl.service;

import com.example.shortenurl.controller.ShortenUrlDTO;
import com.example.shortenurl.controller.UserInputDTO;

import java.util.List;

public interface ShortenUrlService {


    ShortenUrlDTO generateShortenUrl(UserInputDTO userInputDTO);

    ShortenUrlDTO findByShortUrl(String shortenUrl);

    List<ShortenUrlDTO> showAll();

}
