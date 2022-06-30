package com.gustosmusicales.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.dto.MusicalStyleScoreDto;

import org.springframework.stereotype.Repository;

@Repository
public interface MusicalStyleRepository extends JpaRepository<MusicalStyle, Long>{
	@Query(nativeQuery = true, value = "SELECT ms.id AS id, ms.name AS name, (SELECT COUNT(po.id) FROM poll po WHERE po.musical_style_id = ms.id) FROM musical_style ms ORDER BY ms.id ASC")
	List<MusicalStyleScoreDto> findAllWithTotal();
}
