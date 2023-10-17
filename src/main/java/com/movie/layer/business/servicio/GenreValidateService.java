package com.movie.layer.business.servicio;

import com.movie.layer.common.exception.IncorrectGenre;
import com.movie.layer.common.util.ExceptionMessage;
import com.movie.layer.domain.entity.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreValidateService {

    public boolean validate(Genre genre) {
        if(genre.getImage() == null || genre.getName() == null) {
            throw new IncorrectGenre(ExceptionMessage.INCORRECT_GENRE.getMessage());
        }

        return true;
    }
}
