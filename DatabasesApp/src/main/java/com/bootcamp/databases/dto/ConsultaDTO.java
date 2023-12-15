package com.bootcamp.databases.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultaDTO {
  LocalDate fecha;
  Integer idMedico;
  Integer idEspecialidad;
  Integer idPaciente;
}
