package com.gustosmusicales.api.controller;

import com.gustosmusicales.api.dto.MusicalStyleDto;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.service.MusicalStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping(value = "/musical-style")
    public ResponseEntity<MusicalStyle> addMusicalStyle(@RequestBody MusicalStyleDto requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicalStyleService.add(requestBody));
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<MusicalStyle>> findAllMusicalStyles() {
        return ResponseEntity.status(HttpStatus.OK).body(musicalStyleService.getAll());
    }
	
}
