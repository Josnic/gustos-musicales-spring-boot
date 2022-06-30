package com.gustosmusicales.api.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gustosmusicales.api.dto.PollDto;
import com.gustosmusicales.api.models.Poll;
import com.gustosmusicales.api.service.PollService;
import com.gustosmusicales.api.repository.PollRepository;

@Service
public class PollServiceImpl implements PollService {
	
	private final PollRepository pollRepository;
	
	public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

	@Override
	public Poll add(PollDto pollDto) {
		Poll poll = new Poll();
        BeanUtils.copyProperties(pollDto, poll);
        return pollRepository.save(poll);
	}

	@Override
	public List<Poll> getAll() {
		return (List<Poll>) pollRepository.findAll();
	}

}
