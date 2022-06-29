package com.gustosmusicales.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
@Table(name = "poll")
public class Poll {

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "musical_style_id", nullable=false, referencedColumnName = "id")
	private Long musicalStyleId;
	
	@Column(name = "email", nullable = false)
    private String email;

    public Poll() {
    }
    
    
    public Poll(Long musicalStyleId, String email) {
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
