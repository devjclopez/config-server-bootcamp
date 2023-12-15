package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.controller.DetalleConsultaController;
import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.dto.DetalleResponseDTO;
import com.bootcamp.databases.model.*;
import com.bootcamp.databases.repository.*;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleConsultaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetalleConsultaServiceImpl implements DetalleConsultaService {

  private final DetalleConsultaRepository detalleRepository;
  private final ConsultaRepository consultaRepository;

  @Override
  public void registrar(DetalleConsulta detalle) throws Exception {
    detalleRepository.save(detalle);
  }

  @Override
  public void modificar(String id, DetalleConsulta detalle) throws Exception {
    DetalleConsulta detalleExist = detalleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Detalle de consulta no encontrada con ID: " + id));
    detalleExist.setDiagnostico(detalle.getDiagnostico());
    detalleExist.setTratamiento(detalle.getTratamiento());
    detalleExist.setIdConsulta(detalle.getIdConsulta());
    detalleRepository.save(detalleExist);
  }

  @Override
  public DetalleResponseDTO buscar(String id) throws Exception {
    DetalleConsulta detalle = detalleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Detalle de consulta no encontrada"));
    Consulta consulta = consultaRepository.findById(detalle.getIdConsulta()).orElseThrow(() -> new IllegalArgumentException("Consulta no encontrada"));
    DetalleResponseDTO detalleDto = DetalleResponseDTO.builder()
            .diagnostico(detalle.getDiagnostico())
            .tratamiento(detalle.getTratamiento())
            .consulta(consulta)
            .build();
    return detalleDto;
  }

  @Override
  public List<DetalleResponseDTO> listarTodos() throws Exception {
    List<DetalleConsulta> detalles = detalleRepository.findAll();
    List<DetalleResponseDTO> listaDetalles = detalles.stream()
            .map(detalle -> {
              Consulta consulta = consultaRepository.findById(detalle.getIdConsulta()).orElse(new Consulta());
              return DetalleResponseDTO.builder()
                      .diagnostico(detalle.getDiagnostico())
                      .tratamiento(detalle.getTratamiento())
                      .consulta(consulta)
                      .build();
            }).toList();

    return listaDetalles;
  }
}
