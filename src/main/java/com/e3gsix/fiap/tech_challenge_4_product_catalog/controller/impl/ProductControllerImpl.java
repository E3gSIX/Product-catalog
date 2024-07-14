package com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.impl;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.ProductController;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationRequestDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductCreationResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.ProductFindByIdResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.impl.ProductControllerImpl.URI_PRODUCTS;

@RestController
@RequestMapping(URI_PRODUCTS)
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    public static final String URI_PRODUCTS = "/products";
    public static final String URI_FIND_PRODUCT_BY_ID = "/{productId}";

    private final ProductService service;

    @PostMapping
    @Override
    public ResponseEntity create(
            @RequestBody ProductCreationRequestDTO productCreationRequestDTO,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        ProductCreationResponseDTO productCreationResponseDTO = this.service.create(productCreationRequestDTO);

        var uri = uriComponentsBuilder.path(URI_FIND_PRODUCT_BY_ID)
                .buildAndExpand(productCreationResponseDTO.id())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(URI_FIND_PRODUCT_BY_ID)
    @Override
    public ResponseEntity findById(@PathVariable String productId) {
        ProductFindByIdResponseDTO productFindByIdResponseDTO = this.service.findById(productId);
        return ResponseEntity.ok(productFindByIdResponseDTO);
    }
}
