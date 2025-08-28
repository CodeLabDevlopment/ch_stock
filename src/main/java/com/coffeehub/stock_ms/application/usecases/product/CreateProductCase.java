package com.coffeehub.stock_ms.application.usecases.product;

import com.coffeehub.stock_ms.application.gateway.LogsGateway;
import com.coffeehub.stock_ms.application.gateway.MessageDispatcher;
import com.coffeehub.stock_ms.application.gateway.PersistenceGateway;
import com.coffeehub.stock_ms.domain.enums.UpdateType;
import com.coffeehub.stock_ms.domain.model.MessageContext;
import com.coffeehub.stock_ms.domain.model.Product;

import java.time.LocalDateTime;

public record CreateProductCase(PersistenceGateway persistenceGateway, LogsGateway log, MessageDispatcher messageDispatcher) {

    public void execute(Product product) {
        log.debug("Creating product: {}", product);
        this.persistenceGateway.save(product);
        log.info("Product saved successfully");
        this.messageDispatcher.sendMessage(new MessageContext(LocalDateTime.now(), UpdateType.CREATE));
        log.debug("Sending message to catalog service");
    }

}
