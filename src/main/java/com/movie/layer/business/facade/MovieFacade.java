package com.movie.layer.business.facade;

import com.movie.layer.domain.dto.MovieDto;
import com.movie.layer.domain.dto.request.MovieDetailDto;
import com.movie.layer.domain.dto.request.MovieRequest;
import com.movie.layer.domain.dto.request.MovieSearchedDto;
import com.movie.layer.domain.entity.Movie;

import java.util.List;

public interface MovieFacade {

    MovieDetailDto getById(Long id);

    MovieDetailDto create(MovieRequest request);

    MovieDetailDto update(MovieRequest request, Long id);

    void deleteById(Long id);

    List<MovieSearchedDto> filter(String name, Long genre, String order);

    MovieDetailDto addCharacter(Long idMovie, Long idCharacter);

    String deleteCharacter(Long idMovie, Long idCharacter);
}
