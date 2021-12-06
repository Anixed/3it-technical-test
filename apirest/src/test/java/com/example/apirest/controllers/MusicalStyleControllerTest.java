package com.example.apirest.controllers;

import java.util.ArrayList;

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

import com.example.apirest.models.MusicalStyle;
import com.example.apirest.services.MusicalStyleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class MusicalStyleControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private MusicalStyleService musicalStyleService;

    @InjectMocks
    private MusicalStyleController musicalStyleController;
    
    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(musicalStyleController)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }
    
    @Test
    public void shouldReturnMusicalStyles() throws Exception {
    	BDDMockito
    	.given(musicalStyleService.getAll())
    	.willReturn(new ArrayList<MusicalStyle>());
    	
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders
	        		.get("/api/musical-styles")
	        		.accept(MediaType.APPLICATION_JSON)
        		)
                .andReturn()
                .getResponse();
        
        Assertions
        .assertThat(response.getStatus())
        .isEqualTo(HttpStatus.OK.value());
    }
	
}
