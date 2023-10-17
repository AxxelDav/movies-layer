package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.request.GenreRequest;
import com.movie.layer.domain.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Genre toDomain(GenreRequest request) {
        return modelMapper.map(request, Genre.class);
    }

    public List<Genre> toDomain(List<GenreRequest> requests) {
        return requests
                .stream()
                .map(request -> modelMapper.map(request, Genre.class))
                .collect(Collectors.toList());
    }
}
