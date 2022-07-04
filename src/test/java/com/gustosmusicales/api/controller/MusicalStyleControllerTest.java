package com.gustosmusicales.api.controller;

import com.gustosmusicales.api.ApiApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.dto.MusicalStyleDto;
import com.gustosmusicales.api.dto.MusicalStyleScoreDto;
import com.gustosmusicales.api.service.MusicalStyleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@SpringBootTest
public class MusicalStyleControllerTest {
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean 
    private MusicalStyleService musicalStyleService;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Order(1) 
    @DisplayName("JUnit test controller para guardar un estilo musical")
    @Test
    public void verifySaveMusicalStyle() throws Exception {
    	
    	
    	when(musicalStyleService.add(any(MusicalStyleDto.class))).thenReturn(new MusicalStyle((long)1, "Vallenato"));
    	
        mockMvc.perform(MockMvcRequestBuilders.post("/apiv1/musical-style/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"Vallenato\"}")
                .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isCreated())
        		.andDo(print())
        		.andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists());
    }
    
    @Order(2) 
    @DisplayName("JUnit test controller para listar estilos musicales")
    @Test
    public void verifyMusicalStyleList() throws Exception {
    	List<MusicalStyle> styles = new ArrayList<>(
 		        Arrays.asList(new MusicalStyle((long)1, "Rock")));

 		    when(musicalStyleService.getAll()).thenReturn(styles);
    		    
        mockMvc.perform(MockMvcRequestBuilders.get("/apiv1/musical-style/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andDo(print());
    }
    
    @Order(3) 
    @DisplayName("JUnit test controller para listar estilos musicales")
    @Test
    public void verifyMusicalStyleListTotal() throws Exception {
    	 
 		    
 		   List<MusicalStyleScoreDto> styles = new ArrayList<>(
   		        Arrays.asList(new MusicalStyleScoreDto((long)1, "Rock", (long) 0)));
   		    when(musicalStyleService.findAllWithTotal()).thenReturn(styles);
 		    
        mockMvc.perform(MockMvcRequestBuilders.get("/apiv1/musical-style/list-total").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].total").exists())
                .andDo(print());
    }
}
