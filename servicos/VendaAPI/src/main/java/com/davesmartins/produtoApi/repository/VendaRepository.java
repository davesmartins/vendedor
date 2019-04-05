package com.davesmartins.produtoApi.repository;

import com.davesmartins.produtoApi.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
