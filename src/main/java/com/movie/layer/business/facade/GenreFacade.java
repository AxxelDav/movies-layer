package com.movie.layer.business.facade;

import com.movie.layer.domain.dto.GenreDto;
import com.movie.layer.domain.dto.request.GenreRequest;

public interface GenreFacade {

    GenreDto createGenre(GenreRequest request);
}
