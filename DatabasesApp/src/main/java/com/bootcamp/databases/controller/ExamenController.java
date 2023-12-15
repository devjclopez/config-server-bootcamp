package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.service.ExamenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
  private static final Logger logger = LoggerFactory.getLogger(ExamenController.class);

  @Autowired
  private ExamenService service;

  @PostMapping("/nuevo")
  public ResponseEntity<Examen> create(@RequestBody Examen esp) {
    logger.info("Registrar nuevo Examen");
    try {
      service.registrar(esp);
      return ResponseEntity.ok(esp);
    } catch (Exception e) {
      logger.error("No se pudo registrar el examen");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(esp);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Examen> update(@PathVariable("id") int id, @RequestBody Examen p) throws Exception {
    service.modificar(id, p);
    return ResponseEntity.ok(p);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<Examen> buscar(@PathVariable("id") int id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Examen>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
