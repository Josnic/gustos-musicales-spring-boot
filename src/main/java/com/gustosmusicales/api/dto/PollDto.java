package com.gustosmusicales.api.dto;

public class PollDto {

	private Long musicalStyleId;
	
    private String email;

    public PollDto() {
    }
    
    
    public PollDto(Long musicalStyleId, String email) {
        this.musicalStyleId = musicalStyleId;
        this.email = email;
    }
    
	public Long getMusicalStyleId() {
		return musicalStyleId;
	}

	public void setMusicalStyleId(Long musicalStyleId) {
		this.musicalStyleId = musicalStyleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
