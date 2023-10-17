package com.movie.layer.presentation.controller;

import com.movie.layer.business.facade.GenreFacade;
import com.movie.layer.domain.dto.GenreDto;
import com.movie.layer.domain.dto.request.GenreRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/genre")
public class GenreController {


    @Autowired
    private GenreFacade genreFacade;


    @ApiOperation(value = "Crea un nuevo Genre", notes = "Esta Operacion permite crear un nuevo Genre")
    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreRequest genreRequest) {
        GenreDto newGenre = genreFacade.createGenre(genreRequest);
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }
}
