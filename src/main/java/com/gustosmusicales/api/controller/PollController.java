package com.gustosmusicales.api.controller;

import com.gustosmusicales.api.dto.PollDto;
import com.gustosmusicales.api.models.Poll;
import com.gustosmusicales.api.service.PollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PollController {

	@Autowired
    private PollService PollService;
	
	@Autowired
    public PollController(PollService PollService) {
        this.PollService = PollService;
    }

    public PollController() {
    }
    
    @PostMapping(value = "/musical-style")
    public ResponseEntity<Poll> addPoll(@RequestBody PollDto requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(PollService.add(requestBody));
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Poll>> findAllPolls() {
        return ResponseEntity.status(HttpStatus.OK).body(PollService.getAll());
    }
	
}
