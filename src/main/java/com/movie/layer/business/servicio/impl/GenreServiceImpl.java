package com.movie.layer.business.servicio.impl;

import com.movie.layer.business.servicio.GenreService;
import com.movie.layer.domain.entity.Genre;
import com.movie.layer.persistence.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;


    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

}
