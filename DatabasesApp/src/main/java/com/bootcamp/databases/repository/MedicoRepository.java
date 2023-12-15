package com.bootcamp.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
