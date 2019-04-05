package com.davesmartins.produtoApi.controller;

import com.davesmartins.produtoApi.model.Cliente;
import com.davesmartins.produtoApi.model.Estoque;
import com.davesmartins.produtoApi.model.Produto;
import com.davesmartins.produtoApi.model.Venda;
import com.davesmartins.produtoApi.repository.ClienteRepository;
import com.davesmartins.produtoApi.repository.EstoqueRepository;
import com.davesmartins.produtoApi.repository.ProdutoRepository;
import com.davesmartins.produtoApi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Venda> save(@Valid @RequestBody Venda venda, HttpServletResponse response) {
        for (Estoque estoque : estoqueRepository.findAll()) {
            for (Produto produto : venda.getProdutos()) {
                if(produto.getId() == estoque.getProduto().getId()){
                    if(estoque.getQuantidade() < produto.getQuantidade()){
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                    }
                }
            }
        }


        Venda vendaSalva = vendaRepository.save(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Venda>> getById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(!cliente.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        List<Venda> todasAsVendas = vendaRepository.findAll();
        List<Venda> vendas = new ArrayList<>();
        for(Venda v : todasAsVendas){
            if(cliente.get().getId() == v.getCliente().getId()){
                vendas.add(v);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

}
