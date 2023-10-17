package com.movie.layer.business.facade.impl;

import com.movie.layer.business.facade.GenreFacade;
import com.movie.layer.business.mapper.GenreDtoMapper;
import com.movie.layer.business.mapper.GenreRequestMapper;
import com.movie.layer.business.servicio.GenreService;
import com.movie.layer.business.servicio.GenreValidateService;
import com.movie.layer.domain.dto.GenreDto;
import com.movie.layer.domain.dto.request.GenreRequest;
import com.movie.layer.domain.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreFacadeImpl implements GenreFacade {

    @Autowired
    private GenreRequestMapper genreRequestMapper;

    @Autowired
    private GenreDtoMapper genreDtoMapper;

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreValidateService genreValidateService;


    public GenreDto createGenre(GenreRequest request) {
        Genre genreToCreate = genreRequestMapper.toDomain(request); //convierto request a Entity
        genreValidateService.validate(genreToCreate); //realizo validacion pertinente
        Genre genreCreated = genreService.create(genreToCreate); //llamo al servicio que create un Genre
        return genreDtoMapper.toDto(genreCreated); //retorno un GenreDto (mapeo el Genre a GenreDto)
    }


}
