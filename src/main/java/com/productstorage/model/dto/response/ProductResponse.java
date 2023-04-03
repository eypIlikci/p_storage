package com.productstorage.model.dto.response;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal piece;
    private Long limitPiece;
    private Long categoryId;
    private Long storageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPiece() {
        return piece;
    }

    public void setPiece(BigDecimal piece) {
        this.piece = piece;
    }

    public Long getLimitPiece() {
        return limitPiece;
    }

    public void setLimitPiece(Long limitPiece) {
        this.limitPiece = limitPiece;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
}
