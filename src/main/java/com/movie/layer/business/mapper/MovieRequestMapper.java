package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.request.MovieRequest;
import com.movie.layer.domain.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieRequestMapper {

    @Autowired
    private ModelMapper modelMapper;


    public Movie toDomain(MovieRequest request) {
        return modelMapper.map(request, Movie.class);
    }


    public List<Movie> toDomain(List<MovieRequest> requests) {
        return requests
                .stream()
                .map(request -> modelMapper.map(request, Movie.class))
                .collect(Collectors.toList());

    }
}
