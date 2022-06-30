package com.gustosmusicales.api.dto;

import com.gustosmusicales.api.models.MusicalStyle;

public class PollDto {

	private MusicalStyle musicalStyle;
	
    private String email;

    public PollDto() {
    }
    
    
    public PollDto(MusicalStyle musicalStyle, String email) {
        this.musicalStyle = musicalStyle;
        this.email = email;
    }
    
	public MusicalStyle getMusicalStyle() {
		return musicalStyle;
	}

	public void setMusicalStyle(MusicalStyle musicalStyleId) {
		this.musicalStyle = musicalStyleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
