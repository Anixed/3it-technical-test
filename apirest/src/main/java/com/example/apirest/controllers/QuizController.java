package com.example.apirest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.apirest.models.Quiz;
import com.example.apirest.models.SuccessResponse;
import com.example.apirest.services.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@GetMapping("/results")
    public ArrayList<Quiz> all() {
        return quizService.getAll();
    }
	
	@GetMapping(path = "/{id}")
    public Optional<Quiz> get(@PathVariable("id") Long id) {
        return quizService.getById(id);
    }
	
	@PostMapping()
    public SuccessResponse store(@RequestBody Quiz quiz) {
        try {
        	Quiz storedQuiz = quizService.save(quiz);
            return new SuccessResponse("Gracias! Hemos recibido tu respuesta.", storedQuiz);
        } catch(DataIntegrityViolationException ex) {
            throw new ResponseStatusException(
            		HttpStatus.BAD_REQUEST,
            		"El correo electrónico ya se encuentra registrado.",
            		ex);
        }
    }
	
	@DeleteMapping(path = "/{id}")
    public SuccessResponse delete(@PathVariable("id") Long id) {
        try {
        	boolean deleted = quizService.delete(id);
            if (deleted) {
                return new SuccessResponse("Quiz #" + id + " eliminado correctamente.");
            }
            throw new ResponseStatusException(
            		HttpStatus.INTERNAL_SERVER_ERROR,
            		"No se pudo eliminar el Quiz #" + id);
        } catch(EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(
            		HttpStatus.NOT_FOUND,
            		"No se encontró el Quiz #" + id,
            		ex);
        } catch(Exception ex) {
            throw new ResponseStatusException(
            		HttpStatus.INTERNAL_SERVER_ERROR,
            		"Error al eliminar el Quiz #" + id,
            		ex);
        }
    }
	
}
