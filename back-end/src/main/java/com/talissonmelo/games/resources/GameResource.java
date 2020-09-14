package com.talissonmelo.games.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.games.dto.GameDto;
import com.talissonmelo.games.service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameDto>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
