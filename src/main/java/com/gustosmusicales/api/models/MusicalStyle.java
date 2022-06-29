package com.gustosmusicales.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "musical_style")
public class MusicalStyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany(mappedBy="poll")
    private Long id;
	
	@Column(name = "name", nullable = false)
    private String name;

    public MusicalStyle() {
    }

    public MusicalStyle(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
