package com.bootcamp.databases.repository;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleConsultaRepository extends MongoRepository<DetalleConsulta, String> {

}
