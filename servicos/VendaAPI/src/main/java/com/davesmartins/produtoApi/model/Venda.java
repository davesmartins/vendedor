package com.davesmartins.produtoApi.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String data;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", cascade= CascadeType.ALL)
	private List<Produto> produtos;

	private double precoTotal;

	public Venda(Long id, String data, Cliente cliente, ArrayList<Produto> produtos, double precoTotal) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.produtos = produtos;
		this.precoTotal = precoTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
