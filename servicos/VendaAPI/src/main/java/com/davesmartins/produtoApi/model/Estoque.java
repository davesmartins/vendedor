package com.davesmartins.produtoApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long quantidade;

    @OneToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public Estoque(Long quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getQuantidade() {return quantidade;}

    public void setQuantidade(Long quantidade) {this.quantidade = quantidade;}

    public Produto getProduto() {return produto;}

    public void setProduto(Produto produto) {this.produto = produto;}
}
