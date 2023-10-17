package com.movie.layer.business.facade.impl;

import com.movie.layer.business.facade.MovieFacade;
import com.movie.layer.business.mapper.MovieDtoMapper;
import com.movie.layer.business.mapper.MovieRequestMapper;
import com.movie.layer.business.servicio.MovieService;
import com.movie.layer.domain.dto.MovieDto;
import com.movie.layer.domain.dto.request.MovieDetailDto;
import com.movie.layer.domain.dto.request.MovieRequest;
import com.movie.layer.domain.dto.request.MovieSearchedDto;
import com.movie.layer.domain.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFacadeImpl implements MovieFacade {

    @Autowired
    private MovieRequestMapper movieRequestMapper;

    @Autowired
    private MovieDtoMapper movieDtoMapper;

    @Autowired
    private MovieService movieService;



    @Override
    public MovieDetailDto getById(Long id) {
        Movie movie = movieService.getById(id);
        return movieDtoMapper.toMovieDetailDto(movie);
    }

    @Override
    public MovieDetailDto create(MovieRequest request) {
        Movie movieToCreate = movieRequestMapper.toDomain(request);
        Movie movieCreated = movieService.create(movieToCreate);

        return movieDtoMapper.toMovieDetailDto(movieCreated);
    }

    @Override
    public MovieDetailDto update(MovieRequest request, Long id) {
        Movie movie = movieService.getById(id);
        Movie movieToUpdate = movieRequestMapper.toDomain(request);
        Movie movieUpdated = movieService.update(movieToUpdate);
        return movieDtoMapper.toMovieDetailDto(movieUpdated);
    }

    @Override
    public void deleteById(Long id) {
        Movie movie = movieService.getById(id);
        movieService.deleteById(id);
    }

    @Override
    public List<MovieSearchedDto> filter(String name, Long genre, String order) {
        List<Movie> moviesToFilter = movieService.filter(name, genre, order);
        return movieDtoMapper.toSearchMovieDto(moviesToFilter);
    }

    @Override
    public MovieDetailDto addCharacter(Long idMovie, Long idCharacter) {
        Movie movie = movieService.addCharacter(idMovie, idCharacter);
        return movieDtoMapper.toMovieDetailDto(movie);
    }

    @Override
    public String deleteCharacter(Long idCharacter, Long idMovie) {
        return movieService.deleteCharacterById(idCharacter, idMovie);
    }
}
