package com.coffeehub.stock_ms.application.usecases.product;

import com.coffeehub.stock_ms.application.gateway.LogsGateway;
import com.coffeehub.stock_ms.application.gateway.PersistenceGateway;
import com.coffeehub.stock_ms.domain.model.Product;

public record CreateProductCase(PersistenceGateway persistenceGateway, LogsGateway log) {

    public void execute(Product product) {
        log.debug("Creating product: {}", product);
        this.persistenceGateway.save(product);
    }

}
