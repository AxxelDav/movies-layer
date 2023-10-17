package com.movie.layer.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "CALIFICATION")
    private Integer calification;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Genre genre;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_character"
            , joinColumns = {@JoinColumn(name = "movie_id")}
            , inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private List<Characterr> characters;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
    }

}