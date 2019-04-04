package com.davesmartins.produtoApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double preco;

    @NotNull
    private double quantidade;

    @ManyToOne
    @JoinColumn(name="venda_id")
    private Venda venda;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    public Produto(Long id, @NotNull double preco, @NotNull double quantidade, Venda venda, Estoque estoque) {
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.venda = venda;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Estoque getEstoque() {return estoque;}

    public void setEstoque(Estoque estoque) {this.estoque = estoque;}
}
