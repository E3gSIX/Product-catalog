package com.e3gsix.fiap.tech_challenge_4_product_catalog.dto;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;

import java.math.BigInteger;

public record StockProductUpdateResponseDTO(
        String productId,
        BigInteger oldQuantity,
        BigInteger newQuantity
) {
    public static StockProductUpdateResponseDTO fromModel(Product updatedProduct, BigInteger oldQuantity) {
        return new StockProductUpdateResponseDTO(
                updatedProduct.getId(),
                oldQuantity,
                updatedProduct.getQuantity()
        );
    }
}
