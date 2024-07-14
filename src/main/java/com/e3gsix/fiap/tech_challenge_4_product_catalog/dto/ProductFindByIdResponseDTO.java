package com.e3gsix.fiap.tech_challenge_4_product_catalog.dto;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.enums.TypeEnum;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductFindByIdResponseDTO(
        String id,
        String name,
        String description,
        BigDecimal price,
        TypeEnum type,
        BigInteger quantity
) {
    public static ProductFindByIdResponseDTO fromModel(Product product) {
        return new ProductFindByIdResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getType(),
                product.getQuantity()
        );
    }
}
