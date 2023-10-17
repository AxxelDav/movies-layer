package com.movie.layer.domain.dto.request;

import com.movie.layer.domain.dto.MovieDto;
import lombok.Data;

import java.util.List;

@Data
public class CharacterRequest {

    private String image;
    private String name;
    private Integer age;
    private float weight;
    private String history;

    List<MovieDto> movies;
}
