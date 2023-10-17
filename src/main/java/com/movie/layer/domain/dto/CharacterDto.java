package com.movie.layer.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharacterDto {

    private Long id;
    private String image;
    private String name;
    private Integer age;
    private float weight;
    private String history;

    List<MovieDto> movies;
}
