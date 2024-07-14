package com.e3gsix.fiap.tech_challenge_4_product_catalog.dto;

import java.math.BigInteger;

public record StockProductUpdateRequestDTO(
        String productId,
        BigInteger quantity,
        String action
) {
}
