package com.coffeehub.stock_ms.domain.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PROMOTION("Promotion"),
    SOLD_OUT("Sold Out");

    private final String value;

    ProductStatus(String value) {
        this.value = value;
    }
}
