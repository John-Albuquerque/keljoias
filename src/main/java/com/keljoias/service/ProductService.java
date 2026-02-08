package com.keljoias.service;

import com.keljoias.model.Product;
import com.keljoias.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<Product> listarTodos(){
        return repository.findAll();
    }
    public Product salvar(Product product){
        return repository.save(product);
    }
    public Product buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
    public Product atualizar(Long id, Product newProduct){
        Product productExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        productExistente.setName(newProduct.getName());
        productExistente.setDescricao(newProduct.getDescricao());
        productExistente.setPrice(newProduct.getPrice());
        productExistente.setImagem(newProduct.getImagem());

        return repository.save(productExistente);
    }
}
