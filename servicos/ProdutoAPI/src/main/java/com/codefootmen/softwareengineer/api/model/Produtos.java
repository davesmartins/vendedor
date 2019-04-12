package com.codefootmen.softwareengineer.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "produtos")
public class Produtos {

    public Produtos(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name="codigo", referencedColumnName="codigo")
    private Integer codigo;

    @NotNull
    private String nome;

    private double valor;
    private String descricao;
    private double desconto;
    private double qtdEstoque;

    @ManyToOne
    @JoinColumn(name = "categoria_codigo")
    private Categoria categoria;

    public Produtos(@NotNull String nome, double valor, String descricao, double desconto, double qtdEstoque, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.desconto = desconto;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(Long desconto) {
        this.desconto = desconto;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    // Serviço para gravar novos Produtos, mediante o recebimento de um objeto com
    // nome, valor, descrição, desconto, quantidade em estoque e categoria.
    // O serviço deverá retornar o objeto criado

}
