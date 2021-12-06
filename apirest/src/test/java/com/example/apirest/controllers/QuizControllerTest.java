package com.example.apirest.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.apirest.models.Quiz;
import com.example.apirest.services.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private QuizService quizService;

    @InjectMocks
    private QuizController quizController;
    
    private JacksonTester<Quiz> jsonQuiz;
    
    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(quizController)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }
    
    @Test
    public void canCreateNewQuiz() throws Exception {
    	Quiz quiz = new Quiz();
    	quiz.setEmail("example@3it.cl");
    	quiz.setMusicalStylesIds(Arrays.asList(12, 26, 6));
    	
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders
	        		.post("/api/quiz")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(jsonQuiz.write(quiz).getJson())
        		)
        		.andReturn()
        		.getResponse();
        
        Assertions
        .assertThat(response.getStatus())
        .isEqualTo(HttpStatus.OK.value());
    }
    
    @Test
    public void shouldReturnQuizResults() throws Exception {
    	BDDMockito
    	.given(quizService.getAll())
    	.willReturn(new ArrayList<Quiz>());
    	
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders
	        		.get("/api/quiz/results")
	        		.accept(MediaType.APPLICATION_JSON)
        		)
                .andReturn()
                .getResponse();
        
        Assertions
        .assertThat(response.getStatus())
        .isEqualTo(HttpStatus.OK.value());
    }
	
}
