package br.com.nexti.teste.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nexti.teste.model.Cliente;
import br.com.nexti.teste.model.Produto;
import br.com.nexti.teste.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	private final ProdutoRepository produtoDAO;
	
	@Autowired
	public ProdutoController(ProdutoRepository produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
	@GetMapping(path = "/produto")
	public ResponseEntity<?> listarTodos(){
		return new ResponseEntity<>(produtoDAO.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/produto/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){
		Optional<Produto> produto = produtoDAO.findById(id);
		return new ResponseEntity<>(produto,HttpStatus.OK);
	}

	@PostMapping(path="/produto/salvar")
	public ResponseEntity<?> salvar(@RequestBody Produto produto){
		return new ResponseEntity<>(produtoDAO.save(produto),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/produto/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		produtoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="/produto/alterar/{id}")
	public ResponseEntity<?> alterar(@RequestBody Produto produto){
		produtoDAO.save(produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
