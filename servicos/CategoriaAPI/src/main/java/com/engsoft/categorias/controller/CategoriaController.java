package com.engsoft.categorias.controller;


import com.engsoft.categorias.model.Categoria;
import com.engsoft.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")

public class CategoriaController {

@Autowired
private CategoriaRepository categoriaRepository;

    @GetMapping("")
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
    }

@PostMapping ("")
    public ResponseEntity<Categoria> save (@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria  categoriaSalvo = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvo);
}

@GetMapping("/{id}")
public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long id) {
    Optional<Categoria> categoria = categoriaRepository.findById(id);
    if (!categoria.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(categoria.get());
}

    @PutMapping("")
    public ResponseEntity<Categoria> alterar(@Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalvo = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagarPeloCodigo(@PathVariable Long id) {
        Optional<Categoria> categoriaDeletada = categoriaRepository.findById(id);
        if (!categoriaDeletada.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoriaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }


