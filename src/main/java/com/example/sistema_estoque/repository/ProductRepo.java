package com.example.sistema_estoque.repository;

import com.example.sistema_estoque.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
