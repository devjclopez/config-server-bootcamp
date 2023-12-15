package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Paciente;

import java.util.List;

public interface EspecialidadService {

  public void registrar(Especialidad e) throws Exception;

  public void modificar(int id, Especialidad e) throws Exception;

  public Especialidad buscar(int id) throws Exception;

  public List<Especialidad> listarTodos() throws Exception;

}
