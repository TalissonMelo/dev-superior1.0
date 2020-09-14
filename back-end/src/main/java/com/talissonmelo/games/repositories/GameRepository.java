package com.talissonmelo.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.games.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
