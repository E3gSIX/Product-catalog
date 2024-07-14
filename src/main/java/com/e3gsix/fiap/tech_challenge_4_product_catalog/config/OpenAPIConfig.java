package com.e3gsix.fiap.tech_challenge_4_product_catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("Product Catalog API")
                .description("Microsserviço destinado ao catálogo de produtos.")
                .version("v1")
        );
    }
}
