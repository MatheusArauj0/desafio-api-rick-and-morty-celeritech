package com.celeritech.apirickandmorty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeritech.apirickandmorty.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
