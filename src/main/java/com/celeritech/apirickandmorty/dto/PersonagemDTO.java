package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.hateoas.RepresentationModel;

import com.celeritech.apirickandmorty.entities.Personagem;

public class PersonagemDTO extends RepresentationModel<PersonagemDTO> implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String status;
	private String specie;
	private String gender;
	private PersonagemLocalDTO origin;
	private PersonagemLocalDTO location;
	private Instant createdAt;
	
	public PersonagemDTO() {
		
	}
	
	
	public PersonagemDTO(Long id, String name, String status, String specie, String gender, PersonagemLocalDTO origin,
			PersonagemLocalDTO location, Instant createdAt) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.specie = specie;
		this.gender = gender;
		this.origin = origin;
		this.location = location;
		this.createdAt = createdAt;
	}
	
	public PersonagemDTO(Personagem entity) {
		id = entity.getId();
		name = entity.getName();
		status = entity.getStatus();
		specie = entity.getSpecie();
		gender = entity.getGender();
		origin = new PersonagemLocalDTO(entity.getOrigin());
		location = new PersonagemLocalDTO(entity.getLocation());
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


	public PersonagemLocalDTO getOrigin() {
		return origin;
	}


	public void setOrigin(PersonagemLocalDTO origin) {
		this.origin = origin;
	}


	public PersonagemLocalDTO getLocation() {
		return location;
	}


	public void setLocation(PersonagemLocalDTO location) {
		this.location = location;
	}




	public Instant getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	

}
