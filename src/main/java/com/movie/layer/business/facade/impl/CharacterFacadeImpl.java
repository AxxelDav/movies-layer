package com.movie.layer.business.facade.impl;

import com.movie.layer.business.facade.CharacterFacade;
import com.movie.layer.business.mapper.CharacterDtoMapper;
import com.movie.layer.business.mapper.CharacterRequestMapper;
import com.movie.layer.business.servicio.CharacterService;
import com.movie.layer.domain.dto.CharacterDto;
import com.movie.layer.domain.dto.request.CharacterRequest;
import com.movie.layer.domain.dto.request.CharacterFilteredDto;
import com.movie.layer.domain.entity.Characterr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterFacadeImpl implements CharacterFacade {

    @Autowired
    private CharacterRequestMapper characterRequestMapper;

    @Autowired
    private CharacterDtoMapper characterDtoMapper;

    @Autowired
    private CharacterService characterService;



    @Override
    public CharacterDto getById(Long id) {
        Characterr character = characterService.getById(id);
        return characterDtoMapper.toDto(character);
    }


    @Override
    public CharacterDto create(CharacterRequest request) {
        Characterr characterToCreate = characterRequestMapper.toDomain(request);
        Characterr characterCreated = characterService.create(characterToCreate);
        return characterDtoMapper.toDto(characterCreated);
    }


    @Override
    public CharacterDto update(CharacterRequest request, Long id) {
        Characterr character = characterService.getById(id);
        Characterr characterToUpdate = characterRequestMapper.toDomain(request);
        Characterr characterUpdated = characterService.update(characterToUpdate);
        return characterDtoMapper.toDto(characterUpdated);
    }


    @Override
    public void deleteById(Long id) {
        Characterr characterToDelete = characterService.getById(id);
        characterService.deleteById(id);
    }

    @Override
    public List<CharacterFilteredDto> filter(String name, Integer age, Long movies) {
        List<Characterr> characters = characterService.filter(name, age, movies);
        return characterDtoMapper.toCharacterFilteredDto(characters);
    }
}
