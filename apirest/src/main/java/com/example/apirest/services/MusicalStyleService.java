package com.example.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.models.MusicalStyle;
import com.example.apirest.repositories.MusicalStyleRepository;

@Service
public class MusicalStyleService {
	
	@Autowired
	MusicalStyleRepository musicalStyleRepository;
	
	public ArrayList<MusicalStyle> getAll() {
		return (ArrayList<MusicalStyle>) musicalStyleRepository.findAll();
    }
	
	public ArrayList<MusicalStyle> getAllByIds(List<Integer> ids) {
		return (ArrayList<MusicalStyle>) musicalStyleRepository.findAllById(ids);
    }
	
	public Optional<MusicalStyle> getById(Integer id) {
        return musicalStyleRepository.findById(id);
    }
	
}
