package com.codefootmen.softwareengineer.api.repository;

import com.codefootmen.softwareengineer.api.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
