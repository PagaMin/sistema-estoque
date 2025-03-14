package com.example.sistema_estoque.controller;


import com.example.sistema_estoque.entities.ProductEntity;
import com.example.sistema_estoque.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> listOfAllProducts(){
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id){
        Optional<ProductEntity> productEntity = productService.getProductById(id);
        return productEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    //get products with less 5 quantity
    @GetMapping("/less")
    public List<ProductEntity> listProductsWithLowStock() {
        return productService.getProductsWithLowStock();
    }
}
