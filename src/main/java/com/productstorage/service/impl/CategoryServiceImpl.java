package com.productstorage.service.impl;

import com.productstorage.dao.repo.CategoryRepository;
import com.productstorage.model.dto.request.CreateCategoryRequest;
import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.response.CategoryResponse;
import com.productstorage.model.entity.Category;
import com.productstorage.service.CategoryService;
import com.productstorage.util.error.ErrorMessage;
import com.productstorage.util.error.ServiceException;
import com.productstorage.util.mapper.CategoryModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryModelMapper categoryModelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryModelMapper categoryModelMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryModelMapper = categoryModelMapper;
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        validCreateName(request);
        Category category = categoryModelMapper.map(request);
        category = categoryRepository.save(category);
        return categoryModelMapper.map(category);
    }

    @Override
    public CategoryResponse getById(IdRequest request) {
        return categoryModelMapper.map(categoryRepository.findById(request.getId()).orElseThrow(() -> new ServiceException(ErrorMessage.ID)));
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream().map(category -> categoryModelMapper.map(category)).collect(Collectors.toList());
    }

    private void validCreateName(CreateCategoryRequest request){
        Boolean isName = categoryRepository.isByName(request.name);
        if (isName){
            throw new ServiceException(ErrorMessage.USED_NAME);
        }
    }
}
