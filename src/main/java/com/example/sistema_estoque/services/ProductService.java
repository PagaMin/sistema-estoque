package com.example.sistema_estoque.services;

import com.example.sistema_estoque.entities.ProductEntity;
import com.example.sistema_estoque.repository.ProductRepo;
import com.example.sistema_estoque.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//list missing products (less 5 quantity)
//delete by name


@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    //List all Products
    public List<ProductEntity> listAllProducts(){
        return productRepo.findAll();
    }

    //search product by id
    public Optional<ProductEntity> getProductById(Long id){
        return productRepo.findById(id);
    }

    //delete product by id
    public Optional<ProductEntity> deleteById(Long id){
        return productRepo.findById(id);
    }

    //save product
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepo.save(product);
    }

}
