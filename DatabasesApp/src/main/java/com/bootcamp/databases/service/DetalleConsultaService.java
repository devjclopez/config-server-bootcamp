package com.bootcamp.databases.service;

import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.dto.DetalleResponseDTO;
import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;

import java.util.List;

public interface DetalleConsultaService {

  public void registrar(DetalleConsulta detalle) throws Exception;

  public void modificar(String id, DetalleConsulta detalle) throws Exception;

  public DetalleResponseDTO buscar(String id) throws Exception;

  public List<DetalleResponseDTO> listarTodos() throws Exception;

}
