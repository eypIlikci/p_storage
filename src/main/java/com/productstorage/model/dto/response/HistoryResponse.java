package com.productstorage.model.dto.response;

import com.productstorage.model.enums.HistoryType;


import java.time.LocalDateTime;

public class HistoryResponse {
    private Long productId;
    private LocalDateTime date;
    private HistoryType type;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public HistoryType getType() {
        return type;
    }

    public void setType(HistoryType type) {
        this.type = type;
    }
}
