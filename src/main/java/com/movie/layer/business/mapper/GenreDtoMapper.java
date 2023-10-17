package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.GenreDto;
import com.movie.layer.domain.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreDtoMapper {

    @Autowired
    private ModelMapper modelMapper;


    public GenreDto toDto(Genre genre) {
        return modelMapper.map(genre, GenreDto.class);
    }

    public List<GenreDto> toDto(List<Genre> genres) {
        return genres
                .stream()
                .map(genre -> toDto(genre))
                .collect(Collectors.toList());
    }
}
