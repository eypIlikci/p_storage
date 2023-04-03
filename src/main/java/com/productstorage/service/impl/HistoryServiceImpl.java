package com.productstorage.service.impl;

import com.productstorage.dao.repo.HistoryRepository;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.HistoryResponse;
import com.productstorage.model.entity.History;
import com.productstorage.model.enums.HistoryType;
import com.productstorage.service.HistoryService;
import com.productstorage.util.mapper.HistoryModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryModelMapper historyModelMapper;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository, HistoryModelMapper historyModelMapper) {
        this.historyRepository = historyRepository;
        this.historyModelMapper = historyModelMapper;
    }

    @Override
    public List<HistoryResponse> getByProductId(IdRequest request) {
        return historyRepository.findByProductId(request.getId()).stream().map(history -> historyModelMapper.map(history)).collect(Collectors.toList());
    }

    @Override
    public void logCrateHistory(IdRequest request) {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setProductId(request.getId());
        history.setType(HistoryType.CREATE);
        historyRepository.save(history);
    }

    @Override
    public void logUpdateHistory(IdRequest request) {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setProductId(request.getId());
        history.setType(HistoryType.UPDATE);
        historyRepository.save(history);
    }

    @Override
    public void logDeleteHistory(IdRequest request) {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setProductId(request.getId());
        history.setType(HistoryType.DELETE);
        historyRepository.save(history);
    }

    @Override
    public void logAddHistory(IdRequest request) {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setProductId(request.getId());
        history.setType(HistoryType.ADD);
        historyRepository.save(history);
    }

    @Override
    public void logExtractionHistory(IdRequest request) {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setProductId(request.getId());
        history.setType(HistoryType.EXTRACTION);
        historyRepository.save(history);
    }
}
