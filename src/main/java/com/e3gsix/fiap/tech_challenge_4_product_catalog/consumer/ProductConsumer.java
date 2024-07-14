package com.e3gsix.fiap.tech_challenge_4_product_catalog.consumer;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.StockProductUpdateRequestDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.dto.StockProductUpdateResponseDTO;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.service.ProductService;
import com.e3gsix.fiap.tech_challenge_4_product_catalog.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ProductConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService service;

    @Bean(name = "stock-product-update")
    Consumer<StockProductUpdateRequestDTO> consumeStockProductUpdate() {
        return event -> {
            UUID justInMemoryID = UUID.randomUUID();

            logger.info("Event input [{}]: {}", justInMemoryID, StringUtil.toStringWithNoClassName(event));

            StockProductUpdateResponseDTO result = service.updateStock(event);

            logger.info("Event output [{}]: {}", justInMemoryID, StringUtil.toStringWithNoClassName(result));
        };
    }
}

