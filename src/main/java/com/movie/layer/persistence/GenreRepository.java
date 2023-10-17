package com.movie.layer.persistence;

import com.movie.layer.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    public List<Genre> findAllByOrderByImageAsc();

}
