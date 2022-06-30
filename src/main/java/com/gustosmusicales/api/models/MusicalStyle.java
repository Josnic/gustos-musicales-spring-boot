package com.gustosmusicales.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustosmusicales.api.dto.MusicalStyleScoreDto;

@NamedNativeQuery(name = "MusicalStyle.findAllWithTotal",
query = "SELECT ms.id AS id, ms.name AS name, (SELECT COUNT(po.id) FROM poll po WHERE po.musical_style_id = ms.id) as total FROM musical_style ms ORDER BY ms.id ASC",
resultSetMapping = "Mapping.MusicalStyleScoreDto")
@SqlResultSetMapping(name = "Mapping.MusicalStyleScoreDto",
   classes = @ConstructorResult(targetClass = MusicalStyleScoreDto.class,
                                columns = {@ColumnResult(name = "id", type = Long.class),
                                           @ColumnResult(name = "name"),
                                           @ColumnResult(name = "total", type = Long.class)}))

@Entity
@Table(name = "musical_style")
public class MusicalStyle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
