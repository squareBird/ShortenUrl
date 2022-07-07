package com.example.shortenurl.controller;

import com.example.shortenurl.service.ShortenUrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URISyntaxException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShortenUrlNotFoundException.class)
    public ResponseEntity handleCannotFindUrlException(ShortenUrlNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity handleURISyntaxException(URISyntaxException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
