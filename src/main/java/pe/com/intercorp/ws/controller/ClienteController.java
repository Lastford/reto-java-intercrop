package pe.com.intercorp.ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.intercorp.ws.dto.ClienteDto;
import pe.com.intercorp.ws.dto.KpiClienteDto;
import pe.com.intercorp.ws.service.ClienteService;

@RestController
@RequestMapping("")
@Api(value = "Metodos: Clientes", tags = "Intercorp")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/listclientes")
	@ApiOperation(value = "Operacion: Obtener lista de clientes.")
	@ApiResponses(value = { @ApiResponse(code = 1200, message = "Success") })
	public ResponseEntity<List<ClienteDto>> obtenerListaClientes() {
		List<ClienteDto> listaClienteDto = clienteService.obtenerListaClientes();
		return new ResponseEntity<>(listaClienteDto, HttpStatus.OK);
	}
	
	@GetMapping("/kpideclientes")
	@ApiOperation(value = "Operacion: Obtener promedio edad, desviacion estandar.")
	@ApiResponses(value = { @ApiResponse(code = 1200, message = "Success") })
	public ResponseEntity<KpiClienteDto> ObtenerDatosClientes() {
		KpiClienteDto kpiClienteDto = clienteService.obtenerIndicadoresClientes();
		return new ResponseEntity<>(kpiClienteDto, HttpStatus.OK);
	}
	
	@PostMapping("/creacliente")
	@ApiOperation(value = "Operacion: Obtener promedio edad, desviacion estandar.")
	@ApiResponses(value = { @ApiResponse(code = 1200, message = "Success") })
	public ResponseEntity<String> guardarCliente(@RequestBody @Valid ClienteDto cliente) {
		clienteService.guardarCliente(cliente);
		return new ResponseEntity<>("Cliente guardado", HttpStatus.OK);
	}
}
