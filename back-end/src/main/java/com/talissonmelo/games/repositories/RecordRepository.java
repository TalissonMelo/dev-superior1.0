package com.talissonmelo.games.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talissonmelo.games.entities.Record;

public interface RecordRepository  extends JpaRepository<Record, Long>{

	@Query("select obj from Record obj where ( coalesce( :min , null) is null or obj.moment >= :min and coalesce( :max , null) is null or obj.moment <= :max) ")
	Page<Record> findByMoments(Instant min, Instant max, Pageable pageRequest);
}
