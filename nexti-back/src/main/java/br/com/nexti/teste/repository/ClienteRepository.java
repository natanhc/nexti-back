package br.com.nexti.teste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nexti.teste.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	List<Cliente> findByNome(String nome);
}
