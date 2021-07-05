package com.celeritech.apirickandmorty.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_local")
public class Local implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dimension;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
		
	
	@OneToMany(mappedBy = "location")
	private Set<Personagem> personagens = new HashSet<>();
	
	public Local() {
		
	}
	
	public Local(Long id, String name, String dimension, Instant createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.createdAt = createdAt;
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

	public void setPersonagens(Set<Personagem> personagens) {
		this.personagens = personagens;
	}
	
	public Set<Personagem> getPersonagens() {
		return personagens;
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
		Local other = (Local) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
