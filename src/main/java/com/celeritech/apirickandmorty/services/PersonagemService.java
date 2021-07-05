package com.celeritech.apirickandmorty.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celeritech.apirickandmorty.dto.PersonagemDTO;
import com.celeritech.apirickandmorty.dto.PersonagemInsertDTO;
import com.celeritech.apirickandmorty.entities.Local;
import com.celeritech.apirickandmorty.entities.Personagem;
import com.celeritech.apirickandmorty.repositories.LocalRepository;
import com.celeritech.apirickandmorty.repositories.PersonagemRepository;
import com.celeritech.apirickandmorty.services.exceptions.DatabaseException;
import com.celeritech.apirickandmorty.services.exceptions.ResourceNotFoundException;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository repository;
	
	@Autowired
	private LocalRepository localizacaoRepository;	
	
	@Transactional(readOnly = true)
	public Page<PersonagemDTO> findAllPaged(Pageable pageable) {
		Page<Personagem> list = repository.findAll(pageable);
		
		return  list.map(p -> new PersonagemDTO(p));
	}

	@Transactional(readOnly = true)
	public PersonagemDTO findById(Long id) {
		Optional<Personagem> obj = repository.findById(id);
		Personagem entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return  new PersonagemDTO(entity);
	}

	@Transactional
	public PersonagemInsertDTO insert(PersonagemInsertDTO dto) {
		Personagem entity = new Personagem();
		Local origin = localizacaoRepository.getOne(dto.getOrigin().getId());
		Local location = localizacaoRepository.getOne(dto.getLocation().getId());
	
		
		entity.setName(dto.getName());
		entity.setStatus(dto.getStatus());
		entity.setSpecie(dto.getSpecie());
		entity.setGender(dto.getGender());
		entity.setOrigin(origin);
		entity.setLocation(location);		
		
		entity = repository.save(entity);
		return new PersonagemInsertDTO(entity);
		
	}

	@Transactional
	public PersonagemInsertDTO update(Long id, PersonagemInsertDTO dto) {
		try {
			
			Personagem entity = repository.getOne(id);
			
			Local origin = localizacaoRepository.getOne(dto.getOrigin().getId());
			
			Local location = localizacaoRepository.getOne(dto.getLocation().getId());
			
			
			entity.setName(dto.getName());
			entity.setStatus(dto.getStatus());
			entity.setSpecie(dto.getSpecie());
			entity.setGender(dto.getGender());
			
			entity.setOrigin(origin);
			entity.setLocation(location);
			
			entity = repository.save(entity);
			return new PersonagemInsertDTO(entity);
			}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
			}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			}catch(EmptyResultDataAccessException e){
				throw new ResourceNotFoundException("Id not found " + id);
			}catch(DataIntegrityViolationException e) {
				throw new DatabaseException("Integrity violation");
			}
		
	}
}
