package com.bootcamp.databases.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consultaExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaExamen {
	
	@Id
	private String id;

	private int idExamen;

	private int idConsulta;

}
