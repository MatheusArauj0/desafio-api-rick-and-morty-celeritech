package com.celeritech.apirickandmorty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeritech.apirickandmorty.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);
}
