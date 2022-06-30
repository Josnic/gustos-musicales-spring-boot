package com.gustosmusicales.api.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gustosmusicales.api.dto.MusicalStyleDto;
import com.gustosmusicales.api.dto.MusicalStyleScoreDto;
import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.service.MusicalStyleService;

import com.gustosmusicales.api.repository.MusicalStyleRepository;

@Service
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

	@Override
	public List<MusicalStyleScoreDto> findAllWithTotal() {	
		return (List<MusicalStyleScoreDto>) musicalStyleRepository.findAllWithTotal();
	}

}
