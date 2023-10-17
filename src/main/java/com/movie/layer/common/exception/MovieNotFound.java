package com.movie.layer.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFound extends RuntimeException {

    public MovieNotFound(String message) {
        super(message);
    }
}
