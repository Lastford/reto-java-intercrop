package pe.com.intercorp.ws.service;

import java.util.List;

import pe.com.intercorp.ws.dto.ClienteDto;
import pe.com.intercorp.ws.dto.KpiClienteDto;

public interface ClienteService {

	List<ClienteDto> obtenerListaClientes();	
	KpiClienteDto obtenerIndicadoresClientes();
	void guardarCliente(ClienteDto cliente);
}
