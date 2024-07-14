package com.e3gsix.fiap.tech_challenge_4_product_catalog.model;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.model.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Document
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @MongoId
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private TypeEnum type;
    private BigInteger quantity;
    private LocalDate createdAt;

    public void validate() {
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar nulo nem vazio.");
        }

        if (this.description == null || this.description.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode estar nula nem vazia.");
        }

        if (this.price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço do produto deve ser acima de zero.");
        }

        if (this.type == null) {
            throw new IllegalArgumentException("Tipo do produto deve ser informado obrigatoriamente.");
        }

        if (this.quantity.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Quantidade de produtos não podem ser negativas.");
        }
    }
}
