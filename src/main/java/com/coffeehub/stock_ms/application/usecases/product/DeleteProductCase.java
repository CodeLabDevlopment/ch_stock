package com.coffeehub.stock_ms.application.usecases.product;

import com.coffeehub.stock_ms.application.gateway.LogsGateway;
import com.coffeehub.stock_ms.application.gateway.MessageDispatcher;
import com.coffeehub.stock_ms.application.gateway.PersistenceGateway;
import com.coffeehub.stock_ms.domain.enums.UpdateType;
import com.coffeehub.stock_ms.domain.model.MessageContext;
import com.coffeehub.stock_ms.domain.model.Product;

import java.time.LocalDateTime;

public record DeleteProductCase(PersistenceGateway persistenceGateway, LogsGateway log, MessageDispatcher messageDispatcher) {

    public void execute(String productId) {
        log.debug("Deleting product with id {}", productId);
        Product product = this.persistenceGateway.findProductById(productId);
        this.persistenceGateway.delete(product);
        log.info("Product with id {} deleted", productId);
        this.messageDispatcher.sendMessage(new MessageContext(LocalDateTime.now(), UpdateType.DELETE));
        log.debug("Sending message to catalog service");
    }

}
