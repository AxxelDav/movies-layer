package com.movie.layer.business.facade;

import com.movie.layer.domain.dto.CharacterDto;
import com.movie.layer.domain.dto.request.CharacterRequest;
import com.movie.layer.domain.dto.request.CharacterFilteredDto;

import java.util.List;

public interface CharacterFacade {

    CharacterDto getById(Long id);

    CharacterDto create(CharacterRequest request);

    CharacterDto update(CharacterRequest request, Long id);

    void deleteById(Long id);

    List<CharacterFilteredDto> filter(String name, Integer age, Long movies);


}
