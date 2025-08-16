package com.kafkaProduct.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kafkaProduct.DTO.ProductRequest;
import com.kafkaProduct.DTO.ProductResponse;
import com.kafkaProduct.entity.Product;
import com.kafkaProduct.repositoty.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void createProduct(ProductRequest request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		productRepository.save(product);
	}

	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(),
				product.getName(), product.getDescription(), product.getPrice())).collect(Collectors.toList());
	}
	
	public Product updateProduct(Long id, ProductRequest request) {
		Product p = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
		p.setName(request.getName());
		p.setDescription(request.getDescription());
		p.setPrice(request.getPrice());
		return productRepository.save(p);
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);

	}
}
