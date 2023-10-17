package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.request.CharacterRequest;
import com.movie.layer.domain.entity.Characterr;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterRequestMapper {

    @Autowired
    private ModelMapper modelMapper;



    public Characterr toDomain(CharacterRequest request) {
        return modelMapper.map(request, Characterr.class);
    }


    public List<Characterr> toDomain(List<CharacterRequest> requests) {
        return requests
                .stream()
                .map(request -> modelMapper.map(request, Characterr.class))
                .collect(Collectors.toList());
    }
}
