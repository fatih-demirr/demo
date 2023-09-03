package com.example.demo.domain.product;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @NonNull
    List<Product> findAll();

    Optional<Product> getProductById(String id);

    Product findByProductName(String productName);
}
