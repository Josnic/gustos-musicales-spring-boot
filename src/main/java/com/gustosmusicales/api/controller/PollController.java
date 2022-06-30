package com.gustosmusicales.api.controller;

import com.gustosmusicales.api.dto.PollDto;
import com.gustosmusicales.api.models.Poll;
import com.gustosmusicales.api.service.PollService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


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
    
    @PostMapping(value = "/poll/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un nuevo registro de encuenta", tags = { "Encuestas" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
            description = "Nuevo registro de encuenta creado",
            content = @Content(schema =  @Schema(implementation = Poll.class))),
            @ApiResponse(responseCode = "500",
            description = "Error interno de servidor",
            content = @Content)
    })
    public ResponseEntity<Poll> addPoll(@RequestBody PollDto requestBody) {
    	try {
    		return ResponseEntity.status(HttpStatus.CREATED).body(PollService.add(requestBody));
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }

    @GetMapping(value = "/poll//list", produces = "application/json")
    @Operation(summary = "lista todos los datos de encuentas", tags = { "Encuestas" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Detalle de las encuestas",
            		content = @Content(array = @ArraySchema(schema =  @Schema(implementation = Poll.class)))),
            @ApiResponse(responseCode = "500",
            description = "Error interno de servidor",
            content = @Content)
    })
    public ResponseEntity<List<Poll>> findAllPolls() {
    	try {
    		return ResponseEntity.status(HttpStatus.OK).body(PollService.getAll());
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
	
}
