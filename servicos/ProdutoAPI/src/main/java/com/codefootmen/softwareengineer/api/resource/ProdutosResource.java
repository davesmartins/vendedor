package com.codefootmen.softwareengineer.api.resource;

import com.codefootmen.softwareengineer.api.repository.ProdutosRepository;
import com.codefootmen.softwareengineer.api.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping("")
    public ResponseEntity<List<Produtos>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Produtos> criar(@Valid @RequestBody Produtos produto, HttpServletResponse response) {
        Produtos produtoSalvo = produtosRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produtos> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Produtos> produto = produtosRepository.findById(codigo);
        if (!produto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(produto.get());
    }

    @PutMapping("")
    public ResponseEntity<Produtos> alterar(@Valid @RequestBody Produtos produto) {
        Produtos produtoSalvo = produtosRepository.save(produto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(produtoSalvo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagarPeloCodigo(@PathVariable Long codigo) {
        Optional<Produtos> produtoDeletado = produtosRepository.findById(codigo);
        if (!produtoDeletado.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        produtosRepository.deleteById(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
