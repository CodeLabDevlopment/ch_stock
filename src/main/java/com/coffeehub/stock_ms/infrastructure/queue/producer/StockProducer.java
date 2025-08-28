package com.coffeehub.stock_ms.infrastructure.queue.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StockProducer {

    public static final String TO_CATALOG_SERVICE = "toCatalogService-out-0";

    private final StreamBridge streamBridge;

    public StockProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMessage(Message<?> message, String binding) {
        log.debug("Sending message to catalog service: {}", message);
        streamBridge.send(binding, message);
    }

}
