package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.service.ConsultaExamenService;
import com.bootcamp.databases.service.ConsultaExamenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta-examen")
public class ConsultaExamenController {
  private static final Logger logger = LoggerFactory.getLogger(ConsultaExamenController.class);

  @Autowired
  private ConsultaExamenService service;

  @PostMapping("/nuevo")
  public ResponseEntity<ConsultaExamen> create(@RequestBody ConsultaExamen esp) {
    logger.info("Registrar nueva consulta-examen");
    try {
      service.registrar(esp);
      return ResponseEntity.ok(esp);
    } catch (Exception e) {
      logger.error("No se pudo registrar la consulta-examen");
      logger.debug(String.valueOf(e));
      return ResponseEntity.badRequest().body(esp);
    }
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<ConsultaExamen> update(@PathVariable("id") String id, @RequestBody ConsultaExamen p) throws Exception {
    service.modificar(id, p);
    return ResponseEntity.ok(p);
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<ConsultaExamen> buscar(@PathVariable("id") String id) throws Exception {
    return ResponseEntity.ok(service.buscar(id));
  }

  @GetMapping("/listar")
  public ResponseEntity<List<ConsultaExamen>> listar() throws Exception {
    return ResponseEntity.ok(service.listarTodos());
  }

}
