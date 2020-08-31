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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nexti.teste.model.Cliente;
import br.com.nexti.teste.repository.ClienteRepository;

@RestController
public class ClienteController {

	private final ClienteRepository clienteDAO;
	
	@Autowired
	public ClienteController(ClienteRepository clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	@GetMapping(path = "/cliente")
	public ResponseEntity<?> listarTodos(){
		return new ResponseEntity<>(clienteDAO.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/cliente/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){
		Optional<Cliente> cliente = clienteDAO.findById(id);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}

	@PostMapping(path="/cliente/salvar")
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente){
		return new ResponseEntity<>(clienteDAO.save(cliente),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/cliente/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		clienteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="/cliente/alterar/{id}")
	public ResponseEntity<?> alterar(@RequestBody Cliente cliente){
		clienteDAO.save(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/")
	public String home() {
		return "hello world";
	}
	
}
