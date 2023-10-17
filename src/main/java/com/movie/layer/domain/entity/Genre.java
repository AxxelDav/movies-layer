package com.movie.layer.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "GENRE")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IMAGE")
    private String image;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Movie> movies;


}
