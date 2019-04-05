package com.davesmartins.produtoApi.repository;

import com.davesmartins.produtoApi.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
