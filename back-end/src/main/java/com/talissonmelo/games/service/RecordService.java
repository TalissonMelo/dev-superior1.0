package com.talissonmelo.games.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talissonmelo.games.dto.RecordDto;
import com.talissonmelo.games.dto.RecordInsertDto;
import com.talissonmelo.games.entities.Game;
import com.talissonmelo.games.entities.Record;
import com.talissonmelo.games.repositories.GameRepository;
import com.talissonmelo.games.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDto insert(RecordInsertDto recordInsertDto) {
		Record record = new Record();
		record.setName(recordInsertDto.getName());
		record.setAge(recordInsertDto.getAge());
		record.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(recordInsertDto.getGameId());
		record.setGame(game);
		
		record = repository.save(record);
		return new RecordDto(record);
		
	}

	@Transactional
	public Page<RecordDto> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoments(minDate,maxDate,pageRequest).map(record -> new RecordDto(record));
	}
}
