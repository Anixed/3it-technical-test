package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apirest.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
}
