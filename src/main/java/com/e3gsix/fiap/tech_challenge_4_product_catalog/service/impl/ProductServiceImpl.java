package com.e3gsix.fiap.tech_challenge_4_product_catalog.service.impl;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.consumer.StockActionEnum;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.exception.NotFoundException;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.*;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.Product;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.repository.ProductRepository;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

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

    @Override
    public StockProductUpdateResponseDTO updateStock(StockProductUpdateRequestDTO stockProduct) {
        Product product = this.repository.findById(stockProduct.productId())
                .orElseThrow(() -> createNotFound(stockProduct.productId()));

        BigInteger oldQuantity = product.getQuantity();

        if (StockActionEnum.get(stockProduct.action()).isRemoving()) {
            product.reduceQuantity(stockProduct.quantity());
        } else {
            product.includeQuantity(stockProduct.quantity());
        }

        Product updatedProduct = this.repository.save(product);

        return StockProductUpdateResponseDTO.fromModel(updatedProduct, oldQuantity);
    }

    private NotFoundException createNotFound(String productId) {
        return new NotFoundException(String.format("Produto com o ID '%s' não foi encontrado.", productId));
    }
}
