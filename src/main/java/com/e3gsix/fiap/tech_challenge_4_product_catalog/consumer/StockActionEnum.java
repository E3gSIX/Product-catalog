package com.e3gsix.fiap.tech_challenge_4_product_catalog.consumer;

import com.e3gsix.fiap.tech_challenge_4_product_catalog.controller.exception.NotFoundException;

public enum StockActionEnum {
    INCLUDE(),
    REMOVE();

    public static StockActionEnum get(String action) {
        try {
            return StockActionEnum.valueOf(action);
        } catch (Exception exception) {
            throw new NotFoundException("Ação no estoque \"" + action + "\" não é reconhecida.");
        }
    }

    public boolean isRemoving() {
        return this == REMOVE;
    }

}
