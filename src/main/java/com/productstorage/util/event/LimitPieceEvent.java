package com.productstorage.util.event;

import org.springframework.context.ApplicationEvent;

public class LimitPieceEvent {
    private Long productId;

    public LimitPieceEvent(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
