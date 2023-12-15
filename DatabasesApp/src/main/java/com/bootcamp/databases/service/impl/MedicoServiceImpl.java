package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	@Override
	public void registrar(Medico m) throws Exception {
		Medico newMedico = Medico.builder()
						.nombres(m.getNombres())
						.apellidos(m.getApellidos())
						.cmp(m.getCmp())
						.dni(m.getDni())
						.build();
		repo.save(newMedico);
	}

	@Override
	public void modificar(Integer id, Medico m) throws Exception {
		Medico medicoExist = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Medico no encontrado con ID: " + id));
		medicoExist.setNombres(m.getNombres());
		medicoExist.setApellidos(m.getApellidos());
		medicoExist.setCmp(m.getCmp());
		repo.save(medicoExist);
	}

	@Override
	public Medico buscar(int id) throws Exception {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
	}

	@Override
	public List<Medico> listarTodos() throws Exception {
		return repo.findAll();
	}

}
