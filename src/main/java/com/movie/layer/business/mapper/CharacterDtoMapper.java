package com.movie.layer.business.mapper;

import com.movie.layer.domain.dto.CharacterDto;
import com.movie.layer.domain.dto.request.CharacterFilteredDto;
import com.movie.layer.domain.entity.Characterr;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CharacterDto toDto(Characterr characterr) {
        return modelMapper.map(characterr, CharacterDto.class);

    }

    public List<CharacterDto> toDto(List<Characterr> characterrs) {
        return characterrs
                .stream()
                .map(character -> toDto(character))
                .collect(Collectors.toList());
    }

    public CharacterFilteredDto toCharacterFilteredDto(Characterr characterr) {
        return modelMapper.map(characterr, CharacterFilteredDto.class);
    }

    public List<CharacterFilteredDto> toCharacterFilteredDto(List<Characterr> characterrs) {
        return characterrs
                .stream()
                .map(character -> toCharacterFilteredDto(character))
                .collect(Collectors.toList());
    }
}
