package com.e3gsix.fiap.tech_challenge_4_product_catalog.dto;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.enums.TypeEnum;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductCreationRequestDTO(
        String name,
        String description,
        BigDecimal price,
        TypeEnum type,
        BigInteger quantity
) {
    public Product toModel() {
        return new Product(
                null,
                this.name(),
                this.description(),
                this.price(),
                this.type(),
                this.quantity(),
                null
        );
    }
}
