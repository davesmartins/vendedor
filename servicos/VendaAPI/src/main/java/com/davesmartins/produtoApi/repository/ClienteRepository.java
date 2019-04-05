package com.davesmartins.produtoApi.repository;

import com.davesmartins.produtoApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
