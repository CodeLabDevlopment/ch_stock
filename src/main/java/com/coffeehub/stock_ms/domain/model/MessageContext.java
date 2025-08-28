package com.coffeehub.stock_ms.domain.model;

import com.coffeehub.stock_ms.domain.enums.UpdateType;

import java.time.LocalDateTime;

public record MessageContext(
        LocalDateTime timestamp,
        UpdateType updateType
) {

}
