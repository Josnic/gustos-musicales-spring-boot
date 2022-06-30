package com.gustosmusicales.api.service;

import com.gustosmusicales.api.models.MusicalStyle;
import com.gustosmusicales.api.dto.MusicalStyleDto;

import java.util.List;

public interface MusicalStyleService {

	MusicalStyle add(MusicalStyleDto musicalStyleDto);
	List<MusicalStyle> getAll();
}
