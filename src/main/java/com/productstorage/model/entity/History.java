package com.productstorage.model.entity;

import com.productstorage.model.enums.HistoryType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "_history")
public  class History extends BaseEntity{

    private Long productId;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
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
