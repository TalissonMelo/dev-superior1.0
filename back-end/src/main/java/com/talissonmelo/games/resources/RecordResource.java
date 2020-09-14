package com.talissonmelo.games.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.games.dto.RecordDto;
import com.talissonmelo.games.dto.RecordInsertDto;
import com.talissonmelo.games.service.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

	@Autowired
	private RecordService service;
	
	@PostMapping
	public ResponseEntity<RecordDto> insert(@RequestBody RecordInsertDto dto ){
		RecordDto recordDto = service.insert(dto);
		return ResponseEntity.ok().body(recordDto);
	}
}
