package com.movie.layer.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectGenre extends RuntimeException{

    public IncorrectGenre(String message) {
        super(message);
    }
}
