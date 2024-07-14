package com.e3gsix.fiap.tech_challenge_4_product_catalog.service;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationRequestDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductFindByIdResponseDTO;

public interface ProductService {
    ProductCreationResponseDTO create(ProductCreationRequestDTO product);

    ProductFindByIdResponseDTO findById(String productId);
}
