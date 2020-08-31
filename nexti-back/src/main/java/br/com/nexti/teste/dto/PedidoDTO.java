package br.com.nexti.teste.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class PedidoDTO implements Serializable{

	private Integer id;
	private Integer cliente;
	private BigDecimal valorTotalCompra;
	private Date dataCompra;
	private Integer produto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer idCliente) {
		this.cliente = idCliente;
	}
	public BigDecimal getValorTotalCompra() {
		return valorTotalCompra;
	}
	public void setValorTotalCompra(BigDecimal valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
    
	
}
