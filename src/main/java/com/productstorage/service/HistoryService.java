package com.productstorage.service;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.HistoryResponse;

import java.util.List;

public interface HistoryService {
    public List<HistoryResponse> getByProductId(IdRequest request);
    public void logCrateHistory(IdRequest request);
    public void logUpdateHistory(IdRequest request);
    public void logDeleteHistory(IdRequest request);
    public void logAddHistory(IdRequest request);
    public void logExtractionHistory(IdRequest request);
}
