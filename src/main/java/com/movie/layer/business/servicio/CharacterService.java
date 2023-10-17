package com.movie.layer.business.servicio;

import com.movie.layer.domain.entity.Characterr;

import java.util.List;

public interface CharacterService {

    Characterr getById(Long id);

    Characterr create(Characterr character);

    Characterr update(Characterr character);

    void deleteById(Long id);

    List<Characterr> filter(String name, Integer age, Long movies);

}
