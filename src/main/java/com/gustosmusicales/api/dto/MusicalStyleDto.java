package com.gustosmusicales.api.dto;
 
public class MusicalStyleDto {

	private String name;
	
	public MusicalStyleDto() {
    }

    public MusicalStyleDto(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
