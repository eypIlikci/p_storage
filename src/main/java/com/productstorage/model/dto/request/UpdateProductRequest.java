package com.productstorage.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateProductRequest {
    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
