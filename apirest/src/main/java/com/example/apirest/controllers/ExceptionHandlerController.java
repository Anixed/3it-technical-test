package com.example.apirest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.apirest.models.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getReason());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
	
	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMismatchException(Exception ex) {
        return new ErrorResponse("Error en la petición.");
    }
	
	@ExceptionHandler({ NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(Exception ex) {
        return new ErrorResponse("Ruta no encontrada.");
    }
	
}
