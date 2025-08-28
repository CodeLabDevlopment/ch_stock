package com.coffeehub.stock_ms.infrastructure.usecases;

import com.coffeehub.stock_ms.application.gateway.LogsGateway;
import com.coffeehub.stock_ms.application.gateway.MessageDispatcher;
import com.coffeehub.stock_ms.application.gateway.PersistenceGateway;
import com.coffeehub.stock_ms.application.usecases.product.CreateProductCase;
import com.coffeehub.stock_ms.application.usecases.product.DeleteProductCase;
import com.coffeehub.stock_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.stock_ms.application.usecases.product.ListProductsCase;
import com.coffeehub.stock_ms.application.usecases.product.UpdateProductCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCase {

    @Bean
    public FindByProductIdCase findProductByIdCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new FindByProductIdCase(persistenceGateway, logsGateway);
    }

    @Bean
    public ListProductsCase getProductsCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway) {
        return new ListProductsCase(persistenceGateway, logsGateway);
    }

    @Bean
    public CreateProductCase createProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway,
                                               MessageDispatcher messageDispatcher) {
        return new CreateProductCase(persistenceGateway, logsGateway, messageDispatcher);
    }

    @Bean
    public DeleteProductCase deleteProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway,
                                               MessageDispatcher messageDispatcher) {
        return new DeleteProductCase(persistenceGateway, logsGateway, messageDispatcher);
    }

    @Bean
    public UpdateProductCase updateProductCase(PersistenceGateway persistenceGateway, LogsGateway logsGateway,
                                               MessageDispatcher messageDispatcher) {
        return new UpdateProductCase(persistenceGateway, logsGateway, messageDispatcher);
    }

}
