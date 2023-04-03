package com.productstorage.util.mapper;

import com.productstorage.model.dto.request.CreateStorageRequest;
import com.productstorage.model.dto.response.StorageResponse;
import com.productstorage.model.entity.Storage;
import org.springframework.stereotype.Component;


@Component
public class StorageModelMapper {
    public Storage map(CreateStorageRequest request){
        Storage storage =new Storage();
        storage.setName(request.getName());
        storage.setAddress(request.getAddress());
        storage.setState(request.getState());
        storage.setCity(request.getCity());
        return storage;
    }
    public StorageResponse map(Storage storage){
        StorageResponse response = new StorageResponse();
        response.setAddress(storage.getAddress());
        response.setCity(storage.getCity());
        response.setName(storage.getName());
        response.setState(storage.getState());
        response.setId(storage.getId());
        return response;
    }
}
