package com.hari.movie_service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CAST")
public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "MOVIE_ID")
    private Long movie_id;


    @ManyToMany(mappedBy = "casts")
    private Set<Movie> movies;




}
