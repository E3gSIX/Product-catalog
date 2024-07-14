package com.e3gsix.fiap.tech_challenge_4_product_catalog.repository;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
