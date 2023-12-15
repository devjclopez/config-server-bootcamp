package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {

  @Autowired
  private ExamenRepository repository;

  @Override
  public void registrar(Examen e) throws Exception {
    repository.save(e);
  }

  @Override
  public void modificar(int id, Examen e) throws Exception {
    Examen examenExist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Examen no encontrado con ID: " + id));
    examenExist.setNombre(e.getNombre());
    examenExist.setDescripcion(e.getDescripcion());
    repository.save(examenExist);
  }

  @Override
  public Examen buscar(int id) throws Exception {
    Optional<Examen> op = repository.findById(id);
    return op.isPresent() ? op.get() : new Examen();
  }

  @Override
  public List<Examen> listarTodos() throws Exception {
    return repository.findAll();
  }
}
