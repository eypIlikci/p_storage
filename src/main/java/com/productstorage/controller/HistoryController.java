package com.productstorage.controller;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping()
    public ResponseEntity<?> getByProductId(@RequestParam(value = "productId",required = true)Long id){
        IdRequest request = new IdRequest();
        request.setId(id);
        return ResponseEntity.ok(historyService.getByProductId(request));
    }
}
