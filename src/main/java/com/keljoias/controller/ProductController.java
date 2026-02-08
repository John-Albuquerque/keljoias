package com.keljoias.controller;

import com.keljoias.model.Product;
import com.keljoias.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Product>> listarProdutos(){
        return ResponseEntity.ok(service.listarTodos());
    }
    @PostMapping
    public Product criarProduto(@RequestBody Product product){
        return service.salvar(product);
    }
    @GetMapping("/{id}")
    public Product buscarProduto(@PathVariable Long id){
        return service.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        service.deletar(id);
    }
    @PutMapping("/{id}")
    public Product atualizarProduto(@PathVariable Long id,@RequestBody Product product){
        return service.atualizar(id, product);
    }
}
