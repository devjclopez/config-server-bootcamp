package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Examen;

import java.util.List;

public interface ExamenService {

  public void registrar(Examen e) throws Exception;

  public void modificar(int id, Examen e) throws Exception;

  public Examen buscar(int id) throws Exception;

  public List<Examen> listarTodos() throws Exception;

}
