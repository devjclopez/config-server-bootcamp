package com.bootcamp.databases.controller;

import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.dto.DetalleResponseDTO;
import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetalleConsultaController {

  private static final Logger logger = LoggerFactory.getLogger(DetalleConsultaController.class);

  @Autowired
  private DetalleConsultaService service;

  @PostMapping("/nuevo")
  public ResponseEntity<DetalleConsulta> create(@RequestBody DetalleConsulta c) {
    logger.info("Registrar nuevo Detalle de Consulta");
    try {
      service.registrar(c);
      return ResponseEntity.ok(c);
    } catch (Exception e) {
      logger.error("No se pudo registrar el detalle");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(c);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<DetalleConsulta> update(@PathVariable("id") String id, @RequestBody DetalleConsulta detalle) throws Exception {
    service.modificar(id, detalle);
    return ResponseEntity.ok(detalle);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<DetalleResponseDTO> buscar(@PathVariable("id") String id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<DetalleResponseDTO>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
