package com.movie.layer.domain.dto.request;

import com.movie.layer.domain.dto.GenreDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieRequest {

    private String image;
    private String title;
    private LocalDateTime creationDate;
    private Integer calification;

    GenreDto genre;
}
