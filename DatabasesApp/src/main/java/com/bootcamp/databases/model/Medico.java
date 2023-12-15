package com.bootcamp.databases.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	@Column(name = "apellidos", nullable = false, length = 150)
	private String apellidos;
	@Column(name = "cmp", nullable = false, unique = true)
	private String cmp;
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;

}
