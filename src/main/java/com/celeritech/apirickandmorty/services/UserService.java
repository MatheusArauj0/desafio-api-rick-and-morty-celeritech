package com.celeritech.apirickandmorty.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celeritech.apirickandmorty.dto.UserDTO;
import com.celeritech.apirickandmorty.entities.User;
import com.celeritech.apirickandmorty.repositories.UserRepository;
import com.celeritech.apirickandmorty.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return  list.map(u -> new UserDTO(u));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);

	}
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByName(username);
		if(user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Name not found");
		}
		logger.info("User found: " + username);
		return user;
	}

	
	
}
