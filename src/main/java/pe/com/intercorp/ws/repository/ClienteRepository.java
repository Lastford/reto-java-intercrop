package pe.com.intercorp.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.intercorp.ws.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
