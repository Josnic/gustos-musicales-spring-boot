package com.gustosmusicales.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Id;


@Entity
@Table(name = "poll")
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
    private Long id;

	@ManyToOne(cascade = {CascadeType.REMOVE},fetch= FetchType.EAGER)
    @JoinColumn(name = "musical_style_id")
	private MusicalStyle musicalStyle;
	
	@Column(name = "email", nullable = false)
    private String email;

    public Poll() {
    }
    
   
	public MusicalStyle getMusicalStyle() {
		return musicalStyle;
	}

	public void setMusicalStyle(MusicalStyle musicalStyle) {
		this.musicalStyle = musicalStyle;	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
