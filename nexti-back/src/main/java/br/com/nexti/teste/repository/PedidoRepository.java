package br.com.nexti.teste.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nexti.teste.model.Cliente;
import br.com.nexti.teste.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
	List<Pedido> findByDataCompra(String dataCompra);
}
