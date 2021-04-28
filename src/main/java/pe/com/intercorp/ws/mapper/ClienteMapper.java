package pe.com.intercorp.ws.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import pe.com.intercorp.ws.domain.Cliente;
import pe.com.intercorp.ws.dto.ClienteDto;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	ClienteDto map(Cliente cliente);
	List<ClienteDto> map(List<Cliente> listaCliente);	
	
	Cliente map(ClienteDto clienteDto);

	
	
}
