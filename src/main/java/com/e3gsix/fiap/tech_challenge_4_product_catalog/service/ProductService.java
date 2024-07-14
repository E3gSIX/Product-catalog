package com.e3gsix.fiap.tech_challenge_4_product_catalog.service;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.*;

public interface ProductService {
    ProductCreationResponseDTO create(ProductCreationRequestDTO product);

    ProductFindByIdResponseDTO findById(String productId);

    StockProductUpdateResponseDTO updateStock(StockProductUpdateRequestDTO stockProduct);
}
