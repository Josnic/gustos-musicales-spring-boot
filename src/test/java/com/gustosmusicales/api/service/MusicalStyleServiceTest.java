package com.gustosmusicales.api.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import com.gustosmusicales.api.repository.MusicalStyleRepository;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.dto.*;
import com.gustosmusicales.api.service.impl.MusicalStyleServiceImpl;

import static org.mockito.Mockito.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class MusicalStyleServiceTest {
	
	@Mock
    private MusicalStyleRepository musicalStyleRepository;

    @InjectMocks
    private MusicalStyleServiceImpl musicalStyleServiceImpl;

    
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Order(1) 
    @DisplayName("JUnit test service para guardar un estilo musical")
    @Test
    public void saveMusicalStyle() {
    	MusicalStyle style = new MusicalStyle(1L, "Vallenato");
        when(musicalStyleRepository.save(any(MusicalStyle.class))).thenReturn(style);
    	MusicalStyle savedMusicalStyle = musicalStyleServiceImpl.add(new MusicalStyleDto("Vallenato"));
    	assertNotNull(savedMusicalStyle.getName());
    }
    
    @Order(2) 
    @DisplayName("JUnit test service para listar los estilos musicales")
    @Test
    public void getListMusicalStyle() {
    	List<MusicalStyle> musicalStyleList = new ArrayList<MusicalStyle>();
    	musicalStyleList.add(new MusicalStyle((long)1, "Vallenato"));;
        doReturn(musicalStyleList).when(musicalStyleRepository).findAll();
    	
    	List<MusicalStyle> result = musicalStyleServiceImpl.getAll();
        assertEquals(1, result.size());
    }
    
    @Order(3) 
    @DisplayName("JUnit test service para listar los totales de los estilos musicales")
    @Test
    public void getListTotalMusicalStyle() {
    	List<MusicalStyle> musicalStyleList = new ArrayList<MusicalStyle>();
    	musicalStyleList.add(new MusicalStyle((long)1, "Vallenato"));;
        doReturn(musicalStyleList).when(musicalStyleRepository).findAllWithTotal();
        
    	List<MusicalStyleScoreDto> result = musicalStyleServiceImpl.findAllWithTotal();
        assertEquals(1, result.size());
    }

}
