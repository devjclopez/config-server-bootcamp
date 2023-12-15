package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

  @Autowired
  private EspecialidadRepository repository;

  @Override
  public void registrar(Especialidad e) throws Exception {

    repository.save(e);
  }

  @Override
  public void modificar(int id, Especialidad e) throws Exception {
    Especialidad especialidadExist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrads con ID: " + id));
    especialidadExist.setNombre(e.getNombre());
    repository.save(especialidadExist);
  }

  @Override
  public Especialidad buscar(int id) throws Exception {
    Optional<Especialidad> op = repository.findById(id);
    return op.isPresent() ? op.get() : new Especialidad();
  }

  @Override
  public List<Especialidad> listarTodos() throws Exception {
    return repository.findAll();
  }
}
