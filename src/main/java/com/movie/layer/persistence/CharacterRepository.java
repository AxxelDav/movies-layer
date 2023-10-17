package com.movie.layer.persistence;

import com.movie.layer.domain.entity.Characterr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Characterr, Long> {
}
