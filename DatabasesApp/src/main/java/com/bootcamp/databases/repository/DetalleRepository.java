package com.bootcamp.databases.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleRepository extends MongoRepository<DetalleConsulta, Integer> {

}
