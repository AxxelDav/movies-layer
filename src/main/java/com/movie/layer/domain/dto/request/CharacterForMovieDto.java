package com.movie.layer.domain.dto.request;

import lombok.Data;

@Data
public class CharacterForMovieDto {

    private Long id;
    private String image;
    private String name;
    private Integer age;
    private float weight;
    private String history;
}
