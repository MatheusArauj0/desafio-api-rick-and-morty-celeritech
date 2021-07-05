package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.celeritech.apirickandmorty.entities.Local;
import com.celeritech.apirickandmorty.entities.Personagem;

public class LocalDTO extends RepresentationModel<LocalDTO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String name;
	private String dimension;
	private List<String> residents = new ArrayList<>();
	private Instant createdAt;
	
	
	public LocalDTO() {
		
	}

	public LocalDTO(Long id, String name, String dimension, Instant createdAt,
			List<String> personagens) {
		super();
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.createdAt = createdAt;
		this.residents = personagens;
	}
	
	public LocalDTO(Local entity) {
		id = entity.getId();
		name = entity.getName();
		dimension = entity.getDimension();
		createdAt = entity.getCreatedAt();
	}
	
	public LocalDTO(Local entity, Set<Personagem> personagens) {
		this(entity);
		personagens.forEach(p -> this.residents.add(p.getName()));
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

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	
	
	

	

}
