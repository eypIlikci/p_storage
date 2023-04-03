package com.productstorage.controller;

import com.productstorage.model.dto.request.CreateStorageRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(storageService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")Long id){
        IdRequest request = new IdRequest();
        request.setId(id);
        return ResponseEntity.ok(storageService.getById(request));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CreateStorageRequest request){
        return ResponseEntity.ok(storageService.createStorage(request));
    }
}
