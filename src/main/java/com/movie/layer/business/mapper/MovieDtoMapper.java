package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.MovieDto;
import com.movie.layer.domain.dto.request.MovieDetailDto;
import com.movie.layer.domain.dto.request.MovieSearchedDto;
import com.movie.layer.domain.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieDtoMapper {

    @Autowired
    private ModelMapper modelMapper;


    public MovieDto toDto(Movie movie) {
        return modelMapper.map(movie, MovieDto.class);
    }

    public List<MovieDto> toDto(List<Movie> movies) {
        return movies
                .stream()
                .map(movie -> toDto(movie))
                .collect(Collectors.toList());
    }


    public MovieDetailDto toMovieDetailDto(Movie movie) {
        return modelMapper.map(movie, MovieDetailDto.class);
    }


    public MovieSearchedDto toSearchMovieDto(Movie movie) {
        return modelMapper.map(movie, MovieSearchedDto.class);
    }

    public List<MovieSearchedDto> toSearchMovieDto(List<Movie> movies) {
        return movies
                .stream()
                .map(movie -> toSearchMovieDto(movie))
                .collect(Collectors.toList());
    }
}
