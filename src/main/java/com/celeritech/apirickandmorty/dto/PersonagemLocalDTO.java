package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;

import com.celeritech.apirickandmorty.entities.Local;

public class PersonagemLocalDTO /*extends RepresentationModel<PersonagemLocalDTO>*/ implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String url;

	
	public PersonagemLocalDTO() {
		
	}
	
	public PersonagemLocalDTO(String name) {
		this.name = name;
	}
	
	public PersonagemLocalDTO(Local entity) {
		name = entity.getName();
		url = "http://localhost:8080/locais/" + entity.getId();
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

}
