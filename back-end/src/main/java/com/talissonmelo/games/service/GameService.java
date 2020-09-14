package com.talissonmelo.games.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.games.dto.GameDto;
import com.talissonmelo.games.entities.Game;
import com.talissonmelo.games.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameDto> findAll(){
		List<Game> games = repository.findAll();
		return games.stream().map(game -> new GameDto(game)).collect(Collectors.toList());
	}
}
