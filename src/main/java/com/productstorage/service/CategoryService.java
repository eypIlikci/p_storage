package com.productstorage.service;

import com.productstorage.model.dto.request.CreateCategoryRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    public CategoryResponse createCategory(CreateCategoryRequest request);
    public CategoryResponse getById(IdRequest request);
    public List<CategoryResponse> getAll();
}
