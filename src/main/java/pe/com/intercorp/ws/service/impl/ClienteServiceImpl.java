package pe.com.intercorp.ws.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.intercorp.ws.dto.ClienteDto;
import pe.com.intercorp.ws.dto.KpiClienteDto;
import pe.com.intercorp.ws.mapper.ClienteMapper;
import pe.com.intercorp.ws.repository.ClienteRepository;
import pe.com.intercorp.ws.service.ClienteService;
import pe.com.intercorp.ws.util.DateUtils;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Override
	public List<ClienteDto> obtenerListaClientes() {
		
		List<ClienteDto> listaClienteDto = clienteMapper.map(clienteRepository.findAll());
		Integer anosPromedio = 75;
		
		listaClienteDto.stream().forEach(clienteDto -> {
			LocalDate fechaNac = DateUtils.validateFormat(clienteDto.getFechaNacimiento(), "yyyyMMdd");
			if (clienteDto.getEdad() < anosPromedio) {
				fechaNac = fechaNac.plusYears(anosPromedio);
				clienteDto.setFechaProbableMuerte(fechaNac.toString());
			}
		});
		
		return listaClienteDto;
	}

	@Override
	public KpiClienteDto obtenerIndicadoresClientes() {
			
		List<ClienteDto> listaClienteDto = clienteMapper.map(clienteRepository.findAll());
		
		AtomicInteger edadPromedio = new AtomicInteger(0);
		listaClienteDto.stream().forEach(clienteDto -> {
			edadPromedio.set(edadPromedio.get() + clienteDto.getEdad());			
			}
		);
		Double promedio = edadPromedio.doubleValue() / listaClienteDto.size();
		Double varianza = 0.0;
		for (ClienteDto clienteDto : listaClienteDto) {
			Double rango;
			rango = Math.pow(clienteDto.getEdad() - promedio, 2f);
			varianza += rango;
		}
		varianza = varianza/listaClienteDto.size();
		
		Double desviacion = Math.sqrt(varianza);
		System.out.println("promedio:" +promedio);
		System.out.println("varianza:" + varianza);
		System.out.println("desviacion" + desviacion);
		return KpiClienteDto.builder().promedioEdad(promedio).desviacionEstandar(desviacion).build();
		
		
	}

	@Override
	public void guardarCliente(ClienteDto cliente) {		
		clienteRepository.save(clienteMapper.map(cliente));	
	}

}
