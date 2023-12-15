package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import com.bootcamp.databases.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.PacienteRepository;
import com.bootcamp.databases.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	@Override
	public void registrar(Paciente p) throws Exception {
		repo.save(p);
	}

	@Override
	public void modificar(int id, Paciente p) throws Exception {
		Paciente pacienteExist = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado con ID: " + id));
		pacienteExist.setNombres(p.getNombres());
		pacienteExist.setApellidos(p.getApellidos());
		pacienteExist.setDireccion(p.getDireccion());
		pacienteExist.setTelefono(p.getTelefono());
		pacienteExist.setEmail(p.getEmail());
		pacienteExist.setDni(p.getDni());
		repo.save(pacienteExist);
	}

	@Override
	public Paciente buscar(int id) throws Exception {
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public List<Paciente> listarTodos() throws Exception {
		return repo.findAll();
	}

}
