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

import br.com.nexti.teste.dto.PedidoDTO;
import br.com.nexti.teste.model.Cliente;
import br.com.nexti.teste.model.Pedido;
import br.com.nexti.teste.model.Produto;
import br.com.nexti.teste.repository.ClienteRepository;
import br.com.nexti.teste.repository.PedidoRepository;
import br.com.nexti.teste.repository.ProdutoRepository;

@RestController
public class PedidoController {
	@Autowired
	private final PedidoRepository pedidoDAO;
	@Autowired
	private final ClienteRepository clienteRepository;
	@Autowired
	private final ProdutoRepository produtoRepository;

	@Autowired
	public PedidoController(PedidoRepository pedidoDAO, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
		this.pedidoDAO = pedidoDAO;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
	}
	@GetMapping(path = "/pedido")
	public ResponseEntity<?> listarTodos(){
		return new ResponseEntity<>(pedidoDAO.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/pedido/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){
		Optional<Pedido> pedido= pedidoDAO.findById(id);
		return new ResponseEntity<>(pedido,HttpStatus.OK);
	}
	@PostMapping(path="/pedido/salvar")
	public ResponseEntity<?> salvar(@RequestBody PedidoDTO pedidoDto){
		
		Cliente cliente = clienteRepository.findById(pedidoDto.getCliente()).get();
		Produto produto = produtoRepository.findById(pedidoDto.getProduto()).get();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCompra(pedidoDto.getDataCompra());;
		pedido.setProduto(produto);
		pedido.setValorTotalCompra(pedidoDto.getValorTotalCompra());
		
		return new ResponseEntity<>(pedidoDAO.save(pedido),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/pedido/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		pedidoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="/pedido/alterar/{id}")
	public ResponseEntity<?> alterar(@RequestBody Pedido pedido){
		pedidoDAO.save(pedido);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
