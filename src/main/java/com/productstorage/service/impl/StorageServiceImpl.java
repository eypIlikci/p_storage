package com.productstorage.service.impl;

import com.productstorage.dao.repo.StorageRepository;
import com.productstorage.model.dto.request.CreateStorageRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.StorageResponse;
import com.productstorage.model.entity.Storage;
import com.productstorage.service.StorageService;
import com.productstorage.util.error.ErrorMessage;
import com.productstorage.util.error.ServiceException;
import com.productstorage.util.mapper.StorageModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;
    private final StorageModelMapper storageModelMapper;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository, StorageModelMapper storageModelMapper) {
        this.storageRepository = storageRepository;
        this.storageModelMapper = storageModelMapper;
    }

    @Override
    public StorageResponse createStorage(CreateStorageRequest request) {
        validCreateName(request);
        Storage storage = storageModelMapper.map(request);
        storage = storageRepository.save(storage);
        return storageModelMapper.map(storage);
    }

    @Override
    public StorageResponse getById(IdRequest request) {
        return storageModelMapper.map(storageRepository.findById(request.getId()).orElseThrow(() -> new ServiceException(ErrorMessage.ID)));
    }

    @Override
    public List<StorageResponse> getAll() {
        return storageRepository.findAll().stream().map(storage -> storageModelMapper.map(storage)).collect(Collectors.toList());
    }

    private void validCreateName(CreateStorageRequest request){
       Boolean isName = storageRepository.isByName(request.getName());
        if (isName){
            throw new ServiceException(ErrorMessage.USED_NAME);
        }
    }

}
