package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.service.EspecialidadService;
import com.bootcamp.databases.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
  private static final Logger logger = LoggerFactory.getLogger(EspecialidadController.class);

  @Autowired
  private EspecialidadService service;

  @PostMapping("/nuevo")
  public ResponseEntity<Especialidad> create(@RequestBody Especialidad esp) {
    logger.info("Registrar nueva Especialidad");
    try {
      service.registrar(esp);
      return ResponseEntity.ok(esp);
    } catch (Exception e) {
      logger.error("No se pudo registrar la especialidad");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(esp);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Especialidad> update(@PathVariable("id") int id, @RequestBody Especialidad p) throws Exception {
    service.modificar(id, p);
    return ResponseEntity.ok(p);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<Especialidad> buscar(@PathVariable("id") int id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Especialidad>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
