package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.celeritech.apirickandmorty.entities.Local;

public class PersonagemLocalDTO extends RepresentationModel<PersonagemLocalDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String name;

	
	public PersonagemLocalDTO() {
		
	}
	
	public PersonagemLocalDTO(String name) {
		this.name = name;
	}
	
	public PersonagemLocalDTO(Local entity) {
		this.name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

}
