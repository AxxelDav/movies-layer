package com.movie.layer.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDto {

    private Long id;
    private String image;
    private String title;
    private LocalDateTime creationDate;
    private Integer calification;

    GenreDto genre;
}
