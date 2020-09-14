package com.talissonmelo.games.dto;

import java.io.Serializable;
import java.time.Instant;

import com.talissonmelo.games.entities.Record;
import com.talissonmelo.games.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RecordDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String gameTitle;
	private Platform gamePlatform;
	private String genreName;
	
	public RecordDto(Record record) {
		this.id = record.getId();
		this.moment = record.getMoment();
		this.name = record.getName();
		this.age = record.getAge();
		this.gameTitle = record.getGame().getTitle();
		this.gamePlatform = record.getGame().getPlatform();
		this.genreName = record.getGame().getGenre().getName();
	}
}
