package com.gustosmusicales.api.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import com.gustosmusicales.api.repository.MusicalStyleRepository;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.dto.*;
import com.gustosmusicales.api.service.impl.MusicalStyleServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class MusicalStyleServiceTest {
	
	@Mock
    private MusicalStyleRepository musicalStyleRepository;

    @InjectMocks
    private MusicalStyleServiceImpl musicalStyleServiceImpl;
    
    @Order(1) 
    @DisplayName("JUnit test service para guardar un estilo musical")
    @Test
    public void saveMusicalStyle() {
    	MusicalStyleDto musicalStyleDto = new MusicalStyleDto("Pop");
    	MusicalStyle savedMusicalStyle = musicalStyleServiceImpl.add(musicalStyleDto);
        assertThat(savedMusicalStyle).isNotNull();
        assertThat(savedMusicalStyle.getId()).isGreaterThan(0);
    }
    
    @Order(2) 
    @DisplayName("JUnit test service para listar los estilos musicales")
    @Test
    public void getListMusicalStyle() {
    	List<MusicalStyle> result = musicalStyleServiceImpl.getAll();
        assertEquals(1, result.size());
    }
    
    @Order(3) 
    @DisplayName("JUnit test service para listar los totales de los estilos musicales")
    @Test
    
    public void getListTotalMusicalStyle() {
    	List<MusicalStyleScoreDto> result = musicalStyleServiceImpl.findAllWithTotal();
        assertEquals(1, result.size());
    }

}
