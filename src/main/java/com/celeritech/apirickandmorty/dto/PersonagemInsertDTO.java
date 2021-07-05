package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;
import java.time.Instant;

import com.celeritech.apirickandmorty.entities.Personagem;

public class PersonagemInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String status;
	private String specie;
	private String gender;
	private LocalDTO origin;
	private LocalDTO location;

	private Instant createdAt;
	
	public PersonagemInsertDTO() {
		
	}
	
	
	public PersonagemInsertDTO(Long id, String name, String status, String specie, String gender, LocalDTO origin,
			LocalDTO location, Instant createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.specie = specie;
		this.gender = gender;
		this.origin = origin;
		this.location = location;
		this.createdAt = createdAt;
	}
	
	public PersonagemInsertDTO(Personagem entity) {
		id = entity.getId();
		name = entity.getName();
		status = entity.getStatus();
		specie = entity.getSpecie();
		gender = entity.getGender();
		origin = new LocalDTO(entity.getOrigin());
		location = new LocalDTO(entity.getLocation());
		createdAt = entity.getCreatedAt();
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSpecie() {
		return specie;
	}


	public void setSpecie(String specie) {
		this.specie = specie;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDTO getOrigin() {
		return origin;
	}


	public void setOrigin(LocalDTO origin) {
		this.origin = origin;
	}


	public LocalDTO getLocation() {
		return location;
	}


	public void setLocation(LocalDTO location) {
		this.location = location;
	}


	public Instant getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	

}
