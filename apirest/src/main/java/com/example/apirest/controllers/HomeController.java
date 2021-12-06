package com.example.apirest.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	BuildProperties buildProperties;
	
	@GetMapping()
    public ModelAndView index() {
		return new ModelAndView("redirect:/api");
    }
	
	@GetMapping("/api")
    public ResponseEntity<Object> api() {
		HashMap<String, Object> map = new HashMap<>();
	    map.put("dev", "Cristhoper Riquelme");
	    map.put("version", buildProperties.getVersion());
	    
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
	
}
