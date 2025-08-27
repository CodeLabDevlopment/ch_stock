package com.coffeehub.stock_ms.infrastructure.web.request;

import com.coffeehub.stock_ms.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

public record UpdateProductRequest(
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        ProductStatus status,
        List<String> tags
) {

}
