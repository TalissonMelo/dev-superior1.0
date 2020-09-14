package com.talissonmelo.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.games.entities.Record;

public interface RecordRepository  extends JpaRepository<Record, Long>{

}
