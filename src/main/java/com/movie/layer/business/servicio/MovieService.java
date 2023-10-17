package com.movie.layer.business.servicio;

import com.movie.layer.domain.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie getById(Long id);

    Movie create(Movie pelicula);

    Movie update(Movie pelicula);

    void deleteById(Long id);

    List<Movie> filter(String name, Long genre, String order);

    Movie addCharacter(Long idMovie, Long idCharacter);

    String deleteCharacterById(Long idMovie, Long idCharacter);


}
