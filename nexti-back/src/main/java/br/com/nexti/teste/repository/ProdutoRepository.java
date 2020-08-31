package br.com.nexti.teste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nexti.teste.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	List<Produto> findByNome(String nome);
}
