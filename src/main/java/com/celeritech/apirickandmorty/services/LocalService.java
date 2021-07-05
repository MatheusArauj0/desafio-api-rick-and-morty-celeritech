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

import com.celeritech.apirickandmorty.dto.LocalDTO;
import com.celeritech.apirickandmorty.entities.Local;
import com.celeritech.apirickandmorty.repositories.LocalRepository;
import com.celeritech.apirickandmorty.services.exceptions.DatabaseException;
import com.celeritech.apirickandmorty.services.exceptions.ResourceNotFoundException;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository repository;
	
	@Transactional(readOnly = true)
	public Page<LocalDTO> findAllPaged(Pageable pageable) {
		Page<Local> list = repository.findAll(pageable);
		return  list.map(p -> new LocalDTO(p, p.getPersonagens()));
	}
	
	@Transactional(readOnly = true)
	public LocalDTO findById(Long id) {
		Optional<Local> obj = repository.findById(id);
		Local entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new LocalDTO(entity, entity.getPersonagens());
	}
	
	@Transactional
	public LocalDTO insert(LocalDTO dto) {
		Local entity = new Local();
		entity.setName(dto.getName());
		entity.setDimension(dto.getDimension());
		entity = repository.save(entity);
		return new LocalDTO(entity);
	}
	
	@Transactional
	public LocalDTO update(Long id, LocalDTO dto) {
		try {
			Local entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setDimension(dto.getDimension());
			
			entity = repository.save(entity);
			return new LocalDTO(entity);
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
