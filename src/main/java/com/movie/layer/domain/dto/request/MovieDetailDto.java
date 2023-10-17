package com.movie.layer.domain.dto.request;

import com.movie.layer.domain.dto.GenreDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class MovieDetailDto {

    private Long id;
    private String image;
    private String title;
    private LocalDateTime creationDate;
    private Integer calification;

    GenreDto genre;

    List<CharacterForMovieDto> characters;

}
