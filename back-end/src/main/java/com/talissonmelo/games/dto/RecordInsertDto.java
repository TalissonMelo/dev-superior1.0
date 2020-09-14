package com.talissonmelo.games.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RecordInsertDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	private Long gameId;
	
}
