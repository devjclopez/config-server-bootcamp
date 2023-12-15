package com.bootcamp.databases.service;

import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.model.Consulta;

import java.util.List;

public interface ConsultaService {

  public void registrar(ConsultaDTO cdto) throws Exception;

  public void modificar(int id, ConsultaDTO c) throws Exception;

  public Consulta buscar(int id) throws Exception;

  public List<Consulta> listarTodos() throws Exception;

}
