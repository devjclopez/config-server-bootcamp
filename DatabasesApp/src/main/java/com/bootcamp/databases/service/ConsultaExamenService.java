package com.bootcamp.databases.service;

import com.bootcamp.databases.dto.DetalleResponseDTO;
import com.bootcamp.databases.model.ConsultaExamen;

import java.util.List;

public interface ConsultaExamenService {

  public void registrar(ConsultaExamen ce) throws Exception;

  public void modificar(String id, ConsultaExamen ce) throws Exception;

  public ConsultaExamen buscar(String id) throws Exception;

  public List<ConsultaExamen> listarTodos() throws Exception;

}
