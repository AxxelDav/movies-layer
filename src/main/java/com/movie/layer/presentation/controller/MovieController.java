package com.movie.layer.presentation.controller;

import com.movie.layer.business.facade.MovieFacade;
import com.movie.layer.domain.dto.request.MovieDetailDto;
import com.movie.layer.domain.dto.request.MovieRequest;
import com.movie.layer.domain.dto.request.MovieSearchedDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    private MovieFacade movieFacade;


    @ApiOperation(value = "Devuelve una Movie basado en su Id", notes = "Este metodo devuelve una Movie basado en su Id")
    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDto> movieDetail(@PathVariable Long id) {
        MovieDetailDto movie = movieFacade.getById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea una Movie", notes = "Este metodo crea una nueva Movie")
    @PostMapping
    public ResponseEntity<MovieDetailDto> createMovie(@RequestBody MovieRequest request) {
        MovieDetailDto newMovie = movieFacade.create(request);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edita una Movie", notes = "Este metodo permite editar una Movie")
    @PutMapping("/{id}")
    public ResponseEntity<MovieDetailDto> updateMovie(@RequestBody MovieRequest request, Long id) {
        MovieDetailDto newMovie = movieFacade.update(request, id);
        return new ResponseEntity<>(newMovie, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una Movie basado en su Id", notes = "Este metodo permite eliminar una Movie basado en su Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieFacade.deleteById(id);
        return new ResponseEntity<>("Movie eliminada con éxito", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Filtra las Movies por nombre y genero. Y ademas las ordena", notes = "Este metodo permite filtrar Movies por Name, Genre y ademas ordenar de forma Ascendente o Descendente (dependiendo lo que se le pasa como parametro)")
    @GetMapping("/filter")
    public ResponseEntity<List<MovieSearchedDto>> filterMovies(@RequestParam(required = false) String name,
                                                               @RequestParam(required = false) Long genre,
                                                               @RequestParam(required = false) String order) {
        List<MovieSearchedDto> moviesFiltered = movieFacade.filter(name, genre, order);
        return new ResponseEntity<>(moviesFiltered, HttpStatus.OK);
    }

    @ApiOperation(value = "Agrega un Personaje a una Movie", notes = "Este metodo permite agregar un Character a una Movie, cada uno basado en sus Id")
    @PostMapping("/{idMovie}/character/{idCharacter}")
    public ResponseEntity<MovieDetailDto> addCharacterInMovie(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        MovieDetailDto movie = movieFacade.addCharacter(idMovie, idCharacter);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un Character de una Pelicula", notes = "Este metodo permite eliminar un Character de una Movie, cada uno basado en sus Id")
    @DeleteMapping("/{idMovie}/character/{idCharacter}")
    public ResponseEntity<String> deleteCharacterInMovie(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
        String resultMessage = movieFacade.deleteCharacter(idMovie, idCharacter);
        return new ResponseEntity<>(resultMessage, HttpStatus.OK);
    }

}
