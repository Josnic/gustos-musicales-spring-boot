package com.gustosmusicales.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.gustosmusicales.api.models.MusicalStyle;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalStyleRepository extends CrudRepository<MusicalStyle, Long>{
}
