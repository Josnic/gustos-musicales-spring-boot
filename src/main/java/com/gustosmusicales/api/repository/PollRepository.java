package com.gustosmusicales.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustosmusicales.api.models.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{

}
