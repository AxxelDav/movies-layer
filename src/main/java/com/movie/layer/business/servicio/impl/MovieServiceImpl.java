package com.movie.layer.business.servicio.impl;

import com.movie.layer.business.servicio.MovieService;
import com.movie.layer.common.exception.MovieNotFound;
import com.movie.layer.common.exception.CharacterNotFound;
import com.movie.layer.business.servicio.CompareMoviesService;
import com.movie.layer.common.util.ExceptionMessage;
import com.movie.layer.domain.entity.Characterr;
import com.movie.layer.domain.entity.Movie;
import com.movie.layer.persistence.CharacterRepository;
import com.movie.layer.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;


    @Override
    public Movie getById(Long id) throws MovieNotFound {
        return movieRepository.findById(id)
                                  .orElseThrow(() -> new MovieNotFound(ExceptionMessage.MOVIE_NOT_FOUND.getMessage()));
    }


    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }


    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }



    @Override
    public void deleteById(Long id) throws MovieNotFound {
        movieRepository.deleteById(id);
    }



    @Override
    public List<Movie> filter(String name, Long genre, String order) {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> result = new ArrayList<>();

        if(name == null && genre == null && order == null)
            return movies;

        for (Movie movie : movies) {
            if (movie.getTitle().equals(name) || Objects.equals(movie.getGenre().getId(), genre)) {
                result.add(movie);
            }
        }

        if (order != null && order.toUpperCase().equals("ASC")) {
            Collections.sort(movies, new CompareMoviesService());
            result.addAll(movies);
            return result;
        }

        if (order != null && order.toUpperCase().equals("DESC")) {
            Collections.sort(movies, new CompareMoviesService().reversed());
            result.addAll(movies);
            return result;
        }

        return result;
    }



    @Override
    public Movie addCharacter(Long idMovie, Long idCharacter) {
        Movie movie = getById(idMovie);

        Characterr characterr = characterRepository.findById(idCharacter)
                                                  .orElseThrow(() -> new CharacterNotFound(ExceptionMessage.CHARACTER_NOT_FOUND.getMessage()));
        movie.getCharacters().add(characterr);
        return movieRepository.save(movie);
    }



    @Override
    public String deleteCharacterById(Long idMovie, Long idCharacter) {
        Movie movie = getById(idMovie);

        for (Characterr character : movie.getCharacters()) {
            if(Objects.equals(character.getId(), idCharacter)) {
                movieRepository.save(movie);
                return "El Character ".concat(idCharacter.toString()).concat(" Ha sido eliminado de la Movie ".concat(idMovie.toString()));
            }
        }
        return "El Character ".concat(idCharacter.toString()).concat(" NO se encuentra entre los personajes de la Movie ".concat(idMovie.toString()));
    }

}
