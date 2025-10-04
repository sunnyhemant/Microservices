package com.kafkaProduct.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaProduct.DTO.ProductRequest;
import com.kafkaProduct.DTO.ProductResponse;
import com.kafkaProduct.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addProducts")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
        productService.createProduct(request);
        return ResponseEntity.ok("Product created successfully");
    }

    @GetMapping("/productsList")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request){
    	productService.updateProduct(id, request);
		return ResponseEntity.ok("product Updated...");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
    	productService.deleteById(id);
		return ResponseEntity.ok("Product deleted..");
    	
    }
    @GetMapping("/name/{id}")
    public ResponseEntity<String> getProductNameById(@PathVariable Long id) {
        String name = productService.getProductNameById(id);
        return ResponseEntity.ok(name);
    }
}