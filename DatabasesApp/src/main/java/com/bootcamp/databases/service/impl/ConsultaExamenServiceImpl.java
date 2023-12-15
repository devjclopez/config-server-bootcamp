package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.service.ConsultaExamenService;
import com.bootcamp.databases.service.ConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {

  @Autowired
  private ConsultaExamenRepository repository;

  @Override
  public void registrar(ConsultaExamen e) throws Exception {
    repository.save(e);
  }

  @Override
  public void modificar(String id, ConsultaExamen ce) throws Exception {
    ConsultaExamen consultaExamenExist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consulta Examen no encontrado con ID: " + id));
    consultaExamenExist.setIdExamen(ce.getIdExamen());
    consultaExamenExist.setIdConsulta(ce.getIdConsulta());
    repository.save(consultaExamenExist);
  }

  @Override
  public ConsultaExamen buscar(String id) throws Exception {
    Optional<ConsultaExamen> op = repository.findById(id);
    return op.isPresent() ? op.get() : new ConsultaExamen();
  }

  @Override
  public List<ConsultaExamen> listarTodos() throws Exception {
    return repository.findAll();
  }
}
