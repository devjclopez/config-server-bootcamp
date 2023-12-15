package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
  private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

  @Autowired
  private PacienteService service;

  @PostMapping("/nuevo")
  public ResponseEntity<Paciente> create(@RequestBody Paciente p) {
    logger.info("Registrar nuevo Paciente");
    try {
      service.registrar(p);
      return ResponseEntity.ok(p);
    } catch (Exception e) {
      logger.error("No se pudo registrar el paciente");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(p);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Paciente> update(@PathVariable("id") int id, @RequestBody Paciente p) throws Exception {
    service.modificar(id, p);
    return ResponseEntity.ok(p);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<Paciente> buscar(@PathVariable("id") int id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Paciente>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
