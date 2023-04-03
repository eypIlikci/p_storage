package com.productstorage.model.dto.request;

public class ProductFilterRequest {
    private Long storageId;
    private String StorageState;
    private String StorageCity;
    private Long categoryId;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getStorageState() {
        return StorageState;
    }

    public void setStorageState(String storageState) {
        StorageState = storageState;
    }

    public String getStorageCity() {
        return StorageCity;
    }

    public void setStorageCity(String storageCity) {
        StorageCity = storageCity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
