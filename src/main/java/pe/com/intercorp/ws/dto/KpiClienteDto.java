package pe.com.intercorp.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KpiClienteDto {
	
	private Double promedioEdad;
	private Double desviacionEstandar;
}
