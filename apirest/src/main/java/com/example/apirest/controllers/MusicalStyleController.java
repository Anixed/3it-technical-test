package com.example.apirest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.apirest.models.MusicalStyle;
import com.example.apirest.services.MusicalStyleService;

@RestController
@RequestMapping("/api/musical-styles")
public class MusicalStyleController {
	
	@Autowired
	MusicalStyleService musicalStyleService;
	
	@GetMapping()
    public ArrayList<MusicalStyle> all() {
        return musicalStyleService.getAll();
    }
	
	@GetMapping(path = "/{id}")
    public Optional<MusicalStyle> get(@PathVariable("id") Integer id) {
        return musicalStyleService.getById(id);
    }
	
}
