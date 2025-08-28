package com.coffeehub.stock_ms.infrastructure.gateway;

import com.coffeehub.stock_ms.application.gateway.MessageDispatcher;
import com.coffeehub.stock_ms.domain.model.MessageContext;
import com.coffeehub.stock_ms.infrastructure.queue.producer.StockProducer;
import org.springframework.stereotype.Service;

import static com.coffeehub.stock_ms.infrastructure.queue.producer.StockProducer.TO_CATALOG_SERVICE;
import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Service
public class MessageDispatcherImpl implements MessageDispatcher {

    private final StockProducer stockProducer;

    public MessageDispatcherImpl(StockProducer stockProducer) {
        this.stockProducer = stockProducer;
    }

    @Override
    public void sendMessage(MessageContext product) {
        this.stockProducer.sendMessage(
                withPayload(product)
                        .build(),
                TO_CATALOG_SERVICE
        );
    }

}
