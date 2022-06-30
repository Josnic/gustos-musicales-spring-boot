package com.gustosmusicales.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.gustosmusicales.api.models.Poll;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long>{

}
