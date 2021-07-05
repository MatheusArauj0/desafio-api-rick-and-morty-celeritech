package com.celeritech.apirickandmorty.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.celeritech.apirickandmorty.entities.User;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
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

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	
	

	
	
	
	
	
	
	

}
