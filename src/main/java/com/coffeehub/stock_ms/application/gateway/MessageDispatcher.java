package com.coffeehub.stock_ms.application.gateway;

import com.coffeehub.stock_ms.domain.model.MessageContext;

public interface MessageDispatcher {

    void sendMessage(MessageContext product);

}
