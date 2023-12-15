package com.bootcamp.databases.dto;

import com.bootcamp.databases.model.Consulta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalleResponseDTO {
  String diagnostico;
  String tratamiento;
  Consulta consulta;
}
