package com.gustosmusicales.api.controller;

import com.gustosmusicales.api.dto.MusicalStyleDto;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.service.MusicalStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;

import java.util.List;

@RestController
public class MusicalStyleController {

	@Autowired
    private MusicalStyleService musicalStyleService;
	
	@Autowired
    public MusicalStyleController(MusicalStyleService musicalStyleService) {
        this.musicalStyleService = musicalStyleService;
    }

    public MusicalStyleController() {
    }
    
    @PostMapping(value = "/musical-style/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un nuevo estilo", tags = { "Estilos musicales" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
            description = "Nuevo estilo musical creado",
            content = @Content(schema =  @Schema(implementation = MusicalStyle.class))),
            @ApiResponse(responseCode = "500",
            description = "Error interno de servidor",
            content = @Content)
    })
    public ResponseEntity<MusicalStyle> addMusicalStyle(@RequestBody MusicalStyleDto requestBody) {
    	try {
    		
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
        return ResponseEntity.status(HttpStatus.CREATED).body(musicalStyleService.add(requestBody));
    }

    @Operation(summary = "lista todos los estilos musicales", tags = { "Estilos musicales" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Detalle de los estilos usicales",
            		content = @Content(array = @ArraySchema(schema =  @Schema(implementation = MusicalStyle.class)))),
            @ApiResponse(responseCode = "500",
            description = "Error interno de servidor",
            content = @Content)
    })
    @GetMapping(value = "/musical-style/list", produces = "application/json")
    public ResponseEntity<List<MusicalStyle>> findAllMusicalStyles() {
    	try {
    		return ResponseEntity.status(HttpStatus.OK).body(musicalStyleService.getAll());
    	}catch(Exception ex) {
    		
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
        
    }
	
}
