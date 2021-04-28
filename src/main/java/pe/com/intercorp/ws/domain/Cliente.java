package pe.com.intercorp.ws.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Cliente {

	private String nombre;
	private String apellido;
	private Integer edad;

	@Field("fecha_nacimiento")
	private String fechaNacimiento;
	
}
