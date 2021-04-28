package pe.com.intercorp.ws.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClienteDto {

	@Valid
	@NotNull
	private String nombre;
	
	@Valid
	@NotNull
	private String apellido;
	
	@Valid
	@NotNull
	private Integer edad;
	
	@Valid
	@NotNull
	@JsonProperty("fecha_nacimiento")
	private String fechaNacimiento;
	
	private String fechaProbableMuerte;
}
