package com.celeritech.apirickandmorty.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_personagem")
public class Personagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String status;
	private String specie;
	private String gender;
	//private String url;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="origin_id")
	private Local origin;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="location_id")
	private Local location;
	
	public Personagem() {
		
	}

	public Personagem(Long id, String name, String status, String especie, String gender) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.specie = especie;
		this.gender = gender;
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


	public Instant getCreatedAt() {
		return createdAt;
	}
	
	
	public Local getLocation() {
		return location;
	}

	public void setLocation(Local location) {
		this.location = location;
	}
	
	

	public Local getOrigin() {
		return origin;
	}

	public void setOrigin(Local origin) {
		this.origin = origin;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personagem other = (Personagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
