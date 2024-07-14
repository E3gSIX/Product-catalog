package com.e3gsix.fiap.tech_challenge_4_product_catalog.model.enums;

public enum TypeEnum {
    LIGHT(1),
    NORMAL(2),
    HEAVY(3);

    private int id;

    TypeEnum(int id) {
        this.id = id;
    }
}
