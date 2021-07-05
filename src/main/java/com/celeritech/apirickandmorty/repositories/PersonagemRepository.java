package com.celeritech.apirickandmorty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeritech.apirickandmorty.entities.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}
