package com.celeritech.apirickandmorty.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.celeritech.apirickandmorty.dto.PersonagemDTO;
import com.celeritech.apirickandmorty.dto.PersonagemInsertDTO;
import com.celeritech.apirickandmorty.services.PersonagemService;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

	
	@Autowired
	private PersonagemService service;
	
	@GetMapping
	public ResponseEntity<Page<PersonagemDTO>> findAll(Pageable pageable){
		Page<PersonagemDTO> list = service.findAllPaged(pageable);
		
		for(PersonagemDTO personagem : list) {
			long id = personagem.getId();
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonagemController.class).findById(id)).withSelfRel();
			personagem.add(link);
		}
		
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PersonagemDTO> findById(@PathVariable Long id){
		PersonagemDTO dto = service.findById(id);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonagemController.class).findById(id)).withSelfRel();
		dto.add(link);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PersonagemInsertDTO> insert( @RequestBody PersonagemInsertDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<PersonagemInsertDTO> update(@PathVariable Long id, @RequestBody PersonagemInsertDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
