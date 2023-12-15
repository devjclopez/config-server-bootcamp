package com.bootcamp.databases.repository;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.model.DetalleConsulta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaExamenRepository extends MongoRepository<ConsultaExamen, String> {

}
