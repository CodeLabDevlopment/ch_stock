package com.coffeehub.stock_ms.application.usecases.product;

import com.coffeehub.stock_ms.application.gateway.LogsGateway;
import com.coffeehub.stock_ms.application.gateway.PersistenceGateway;
import com.coffeehub.stock_ms.domain.model.Product;

public record FindByProductIdCase(PersistenceGateway persistenceGateway, LogsGateway log) {

    public Product execute(String productId) {
        log.debug("Find product by id: {}", productId);
        return this.persistenceGateway.findProductById(productId);
    }

}
