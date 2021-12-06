package com.example.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.models.MusicalStyle;
import com.example.apirest.models.Quiz;
import com.example.apirest.repositories.MusicalStyleRepository;
import com.example.apirest.repositories.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	MusicalStyleRepository musicalStyleRepository;
	
	public ArrayList<Quiz> getAll() {
		return (ArrayList<Quiz>) quizRepository.findAll();
    }
	
	public Optional<Quiz> getById(Long id) {
        return quizRepository.findById(id);
    }
	
	public Quiz save(Quiz quiz) {
		List<MusicalStyle> musicalStyles = (ArrayList<MusicalStyle>) musicalStyleRepository.findAllById(quiz.getMusicalStylesIds());
		quiz.setMusicalStyles(musicalStyles);
        return quizRepository.save(quiz);
    }
	
	public boolean delete(Long id) {
        quizRepository.deleteById(id);
        return true;
    }
	
}
