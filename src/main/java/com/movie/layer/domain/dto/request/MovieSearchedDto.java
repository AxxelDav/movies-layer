package com.movie.layer.domain.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieSearchedDto {

    private String image;
    private String title;
    private LocalDateTime creationDate;
}
