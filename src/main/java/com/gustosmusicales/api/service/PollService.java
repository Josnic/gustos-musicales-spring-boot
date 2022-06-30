package com.gustosmusicales.api.service;

import com.gustosmusicales.api.models.Poll;
import com.gustosmusicales.api.dto.PollDto;
import java.util.List;

public interface PollService {

	Poll add(PollDto PollDto);
	List<Poll> getAll();
}
