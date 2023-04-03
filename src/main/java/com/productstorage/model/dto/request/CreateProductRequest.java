package com.productstorage.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateProductRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private BigDecimal piece;
    @NotNull
    private Long limitPiece;
    @NotNull
    private Long categoryId;
    @NotNull
    private Long storageId;

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
