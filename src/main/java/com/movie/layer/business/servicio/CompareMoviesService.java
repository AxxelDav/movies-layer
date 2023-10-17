package com.movie.layer.business.servicio;

import com.movie.layer.domain.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class CompareMoviesService implements Comparator<Movie> {

    @Override
    public int compare(Movie p1, Movie p2) {
        if(p1.getCreationDate().isAfter(p2.getCreationDate())) {
            return -1;
        } else if (p1.getCreationDate().isBefore(p2.getCreationDate())) {
            return 0;
        } else {
            return 1;
        }
    }
}
