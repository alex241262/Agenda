package com.devalexandre.agenda1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devalexandre.agenda1.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	
}