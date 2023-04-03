package com.productstorage.service;

import com.productstorage.model.dto.request.CreateStorageRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.StorageResponse;

import java.util.List;

public interface StorageService {
    public StorageResponse createStorage(CreateStorageRequest request);
    public StorageResponse getById(IdRequest request);
    public List<StorageResponse> getAll();
}
