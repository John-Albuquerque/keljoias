package com.keljoias.config;

import com.keljoias.model.Product;
import com.keljoias.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ProductRepository repository;

    public DataLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) {

            repository.save(new Product(
                    "Anel Ouro 18k",
                    "Anel delicado em ouro 18k",
                    1299.90,
                    "/images/anel.jpg"
            ));

            repository.save(new Product(
                    "Colar Feminino Luxo",
                    "Colar elegante com acabamento premium",
                    899.90,
                    "/images/colar.jpg"
            ));

            repository.save(new Product(
                    "Pulseira Clássica",
                    "Pulseira sofisticada para ocasiões especiais",
                    499.90,
                    "/images/pulseira.jpg"
            ));
        }
    }
}
