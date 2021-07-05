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

import com.celeritech.apirickandmorty.dto.LocalDTO;
import com.celeritech.apirickandmorty.services.LocalService;

@RestController
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	private LocalService service;
	
	@GetMapping
	public ResponseEntity<Page<LocalDTO>> findAll(Pageable pageable){
		Page<LocalDTO> list = service.findAllPaged(pageable);
		
		for(LocalDTO local : list) {
			long id = local.getId();
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LocalController.class).findById(id)).withSelfRel();
			local.add(link);
		}
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<LocalDTO> findById(@PathVariable Long id){
		LocalDTO dto = service.findById(id);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LocalController.class).findById(id)).withSelfRel();
		dto.add(link.withSelfRel());
		
		return ResponseEntity.ok().body(dto);
	}
	
	
	@PostMapping
	public ResponseEntity<LocalDTO> insert( @RequestBody LocalDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<LocalDTO> update(@PathVariable Long id, @RequestBody LocalDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
