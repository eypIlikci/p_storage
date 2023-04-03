package com.productstorage.controller;


import com.productstorage.model.dto.request.CreateCategoryRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")Long id){
        IdRequest request = new IdRequest();
        request.setId(id);
        return ResponseEntity.ok(categoryService.getById(request));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CreateCategoryRequest request){
        return ResponseEntity.ok(categoryService.createCategory(request));
    }
}
