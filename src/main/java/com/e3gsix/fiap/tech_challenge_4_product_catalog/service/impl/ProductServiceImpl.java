package com.e3gsix.fiap.tech_challenge_4_product_catalog.service.impl;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.exception.NotFoundException;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationRequestDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductFindByIdResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.repository.ProductRepository;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductCreationResponseDTO create(ProductCreationRequestDTO productCreationRequestDTO) {
        Product productToCreate = productCreationRequestDTO.toModel();

        productToCreate.validate();

        Product createdProduct = this.repository.save(productToCreate);

        return ProductCreationResponseDTO.fromModel(createdProduct);
    }

    @Override
    public ProductFindByIdResponseDTO findById(String productId) {
        Product product = this.repository.findById(productId)
                .orElseThrow(() -> createNotFound(productId));

        return ProductFindByIdResponseDTO.fromModel(product);
    }

    private NotFoundException createNotFound(String productId) {
        return new NotFoundException("Produto com o ID " + productId + " não foi encontrado.");
    }
}
