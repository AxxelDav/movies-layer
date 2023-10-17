package com.movie.layer.presentation.controller;


import com.movie.layer.business.facade.CharacterFacade;
import com.movie.layer.domain.dto.CharacterDto;
import com.movie.layer.domain.dto.request.CharacterFilteredDto;
import com.movie.layer.domain.dto.request.CharacterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/character")
public class CharacterController {


    @Autowired
    private CharacterFacade characterFacade;


    @ApiOperation(value = "Regresa detalle de Character basado en su Id", notes = "Este metodo obtener los detalles de un Character basado en su Id")
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> findCharacterById(@PathVariable Long id) {
        CharacterDto characterr = characterFacade.getById(id);
        return new ResponseEntity<>(characterr, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea un Character", notes = "Este metodo crea un nuevo Character")
    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CharacterRequest request) {
        CharacterDto newCharacterr = characterFacade.create(request);
        return new ResponseEntity<>(newCharacterr, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edita un Character", notes = "Este metodo permite editar un Character")
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> updateCharacter(@RequestBody CharacterRequest request, @PathVariable Long id) {
        CharacterDto characterrUpdated = characterFacade.update(request, id);
        return new ResponseEntity<>(characterrUpdated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina un Personaje basado en su Id", notes = "Este metodo permite eliminar un Personaje basado en su Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        characterFacade.deleteById(id);
        return new ResponseEntity<>("Character eliminado con éxito", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Filtra Personaje por nombre, genero o  el Id de sus Peliculas", notes = "Este metodo permite filtrar Personajes por nombre, genero o  el Id de las Peliculas en las que participa")
    @GetMapping("/filter")
    public ResponseEntity<List<CharacterFilteredDto>> characterFilter(@RequestParam(required = false) String name,
                                                                      @RequestParam(required = false) Integer age,
                                                                      @RequestParam(required = false) Long movies) {
        List<CharacterFilteredDto> charactersSearched = characterFacade.filter(name, age, movies);
        return new ResponseEntity<>(charactersSearched, HttpStatus.OK);
    }

}
