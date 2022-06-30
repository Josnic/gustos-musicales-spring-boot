package com.gustosmusicales.api.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gustosmusicales.api.dto.MusicalStyleDto;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.service.MusicalStyleService;
import com.gustosmusicales.api.repository.MusicalStyleRepository;

public class MusicalStyleServiceImpl implements MusicalStyleService {
	
	private final MusicalStyleRepository musicalStyleRepository;
	
	public MusicalStyleServiceImpl(MusicalStyleRepository musicalStyleRepository) {
        this.musicalStyleRepository = musicalStyleRepository;
    }

	@Override
	public MusicalStyle add(MusicalStyleDto musicalStyleDto) {
		MusicalStyle musicalStyle = new MusicalStyle();
        BeanUtils.copyProperties(musicalStyleDto, musicalStyle);
        return musicalStyleRepository.save(musicalStyle);
	}

	@Override
	public List<MusicalStyle> getAll() {
		return (List<MusicalStyle>) musicalStyleRepository.findAll();
	}

}
