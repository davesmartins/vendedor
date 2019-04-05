package com.davesmartins.produtoApi.repository;

import com.davesmartins.produtoApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
