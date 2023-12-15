package com.bootcamp.databases.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	private MedicoService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) {
		logger.info("Registrar nuevo médico");
		try {
			service.registrar(m);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			logger.error("No se pudo registrar el médico");
			logger.debug(String.valueOf(e));
			return ResponseEntity.badRequest().body(m);
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Medico> actualizar(@PathVariable("id") Integer id, @RequestBody Medico m) throws Exception {
		service.modificar(id, m);
		return ResponseEntity.ok(m);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Medico> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
