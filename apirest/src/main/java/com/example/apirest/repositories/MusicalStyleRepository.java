package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apirest.models.MusicalStyle;

@Repository
public interface MusicalStyleRepository extends JpaRepository<MusicalStyle, Integer> {
	
}
