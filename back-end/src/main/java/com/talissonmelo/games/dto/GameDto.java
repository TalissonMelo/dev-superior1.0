package com.talissonmelo.games.dto;

import java.io.Serializable;

import com.talissonmelo.games.entities.Game;
import com.talissonmelo.games.entities.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GameDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Platform platform;
	
	public GameDto(Game game) {
		this.id = game.getId();
		this.name = game.getTitle();
		this.platform = game.getPlatform();
	}
}
