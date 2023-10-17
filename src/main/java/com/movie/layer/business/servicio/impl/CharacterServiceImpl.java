package com.movie.layer.business.servicio.impl;

import com.movie.layer.business.servicio.CharacterService;
import com.movie.layer.common.exception.CharacterNotFound;
import com.movie.layer.common.util.ExceptionMessage;
import com.movie.layer.domain.entity.Characterr;
import com.movie.layer.domain.entity.Movie;
import com.movie.layer.persistence.CharacterRepository;
import com.movie.layer.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public Characterr getById(Long id) throws CharacterNotFound {
        return characterRepository.findById(id)
                                   .orElseThrow(() -> new CharacterNotFound(ExceptionMessage.CHARACTER_NOT_FOUND.getMessage()));
    }


    @Override
    public Characterr create(Characterr characterr) {
        return characterRepository.save(characterr);
    }


    @Override
    public Characterr update(Characterr characterr) {
        return characterRepository.save(characterr);
    }


    @Override
    public void deleteById(Long id) throws CharacterNotFound {
        characterRepository.deleteById(id);
    }


    @Override
    public List<Characterr> filter(String name, Integer age, Long movies) {
        List<Characterr> characterrs = characterRepository.findAll();
        List<Characterr> result = new ArrayList<>();

        if (name == null && age == null && movies == null)
            return characterrs;

        for (Characterr characterr : characterrs) {
            if (characterr.getName().equals(name) || Objects.equals(characterr.getAge(), age))
                result.add(characterr);
            else {
                for (Movie movie : characterr.getMovies()) {
                    if(Objects.equals(movie.getId(), movies))
                        result.add(characterr);
                }
            }
        }
        return result;
    }
}
