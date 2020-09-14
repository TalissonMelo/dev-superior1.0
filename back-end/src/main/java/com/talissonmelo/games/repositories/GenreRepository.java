package com.talissonmelo.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.games.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
