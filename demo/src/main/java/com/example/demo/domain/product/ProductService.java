package com.example.demo.domain.product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityExistsException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.getProductById(id);
    }

    @Transactional
    public Product createProduct(Product product) {
        Product product1 = productRepository.findByProductName(product.getProductName());
        if(product1 != null){
            throw new EntityExistsException("Product with name " + product1.getProductName() + " already exists");
        }
        return productRepository.save(product);
    }

    @Transactional
    public boolean deleteProduct(String id) {
        Optional<Product> optionalProduct = productRepository.getProductById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Product updateProduct(String id, Product product) {
        Optional<Product> optionalProduct = productRepository.getProductById(id);
        Product existingProduct = optionalProduct.orElseThrow(()->new EntityNotFoundException("Product Not Found"));
        BeanUtils.copyProperties(product, existingProduct, "id");
        return productRepository.save(existingProduct);

    }
}
