package com.coffeehub.stock_ms.infrastructure.web.response.v1;

import com.coffeehub.stock_ms.domain.enums.ProductCategory;
import com.coffeehub.stock_ms.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseList(
        String id,
        String name,
        BigDecimal price,
        ProductCategory category,
        ProductStatus status,
        List<String> tags
) {

}
