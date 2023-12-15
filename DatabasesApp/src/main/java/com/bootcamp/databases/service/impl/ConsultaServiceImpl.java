package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.dto.ConsultaDTO;
import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.repository.PacienteRepository;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

  private final ConsultaRepository repository;
  private final MedicoRepository medicoRepository;
  private final EspecialidadRepository espRepository;
  private final PacienteRepository pacienteRepository;

  @Override
  public void registrar(ConsultaDTO cdto) throws Exception {
    Medico medico = medicoRepository.findById(cdto.getIdMedico()).orElseThrow(() -> new IllegalArgumentException("Medico no encontrado"));
    Especialidad especialidad = espRepository.findById(cdto.getIdEspecialidad()).orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrads"));
    Paciente paciente = pacienteRepository.findById(cdto.getIdPaciente()).orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    Consulta consulta = new Consulta();
    consulta.setFecha(cdto.getFecha());
    consulta.setMedico(medico);
    consulta.setEspecialidad(especialidad);
    consulta.setPaciente(paciente);
    repository.save(consulta);
  }

  @Override
  public void modificar(int id, ConsultaDTO cdto) throws Exception {
    Consulta consultaExist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consulta no encontrada con ID: " + id));
    Medico medico = medicoRepository.findById(cdto.getIdMedico()).orElseThrow(() -> new IllegalArgumentException("Medico no encontrado"));
    Especialidad especialidad = espRepository.findById(cdto.getIdEspecialidad()).orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrads"));
    Paciente paciente = pacienteRepository.findById(cdto.getIdPaciente()).orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    consultaExist.setFecha(cdto.getFecha());
    consultaExist.setMedico(medico);
    consultaExist.setEspecialidad(especialidad);
    consultaExist.setPaciente(paciente);
    repository.save(consultaExist);
  }

  @Override
  public Consulta buscar(int id) throws Exception {
    Optional<Consulta> op = repository.findById(id);
    return op.isPresent() ? op.get() : new Consulta();
  }

  @Override
  public List<Consulta> listarTodos() throws Exception {
    return repository.findAll();
  }
}
