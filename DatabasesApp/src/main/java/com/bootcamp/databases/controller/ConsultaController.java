package com.bootcamp.databases.controller;

import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.service.ConsultaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
  private static final Logger logger = LoggerFactory.getLogger(ConsultaController.class);

  @Autowired
  private ConsultaService service;

  @PostMapping("/nuevo")
  public ResponseEntity<ConsultaDTO> create(@RequestBody ConsultaDTO c) {
    logger.info("Registrar nueva Consulta");
    try {
      service.registrar(c);
      return ResponseEntity.ok(c);
    } catch (Exception e) {
      logger.error("No se pudo registrar la Consulta");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(c);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<ConsultaDTO> update(@PathVariable("id") int id, @RequestBody ConsultaDTO c) throws Exception {
    service.modificar(id, c);
    return ResponseEntity.ok(c);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<Consulta> buscar(@PathVariable("id") int id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Consulta>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
