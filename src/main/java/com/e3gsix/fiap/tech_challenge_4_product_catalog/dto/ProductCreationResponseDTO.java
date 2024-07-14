package com.e3gsix.fiap.tech_challenge_4_product_catalog.dto;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;

public record ProductCreationResponseDTO(String id) {
    public static ProductCreationResponseDTO fromModel(Product product) {
        return new ProductCreationResponseDTO(product.getId());
    }
}
