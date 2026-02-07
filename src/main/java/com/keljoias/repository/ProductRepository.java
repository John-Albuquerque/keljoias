package com.keljoias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.keljoias.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
