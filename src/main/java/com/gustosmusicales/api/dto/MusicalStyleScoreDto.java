package com.gustosmusicales.api.dto;

public class MusicalStyleScoreDto {

    private Long id;
	
    private String name;
    
    private Long total;

    public MusicalStyleScoreDto() {
    }

    public MusicalStyleScoreDto(Long id, String name, Long total) {
        this.id = id;
        this.name = name;
        this.total = total;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setTotal(Long total) {
		this.total = total;
	}
	
	public Long getTotal() {
		return this.total;
	}
}
