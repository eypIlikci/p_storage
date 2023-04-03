package com.productstorage.util.mapper;

import com.productstorage.model.dto.request.CreateCategoryRequest;
import com.productstorage.model.dto.response.CategoryResponse;
import com.productstorage.model.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryModelMapper {
    public Category map(CreateCategoryRequest request){
        Category category = new Category();
        category.setName(request.name);
        return category;
    }
    public CategoryResponse map(Category category){
        CategoryResponse response=new CategoryResponse();
        response.setName(category.getName());
        response.setId(category.getId());
        return response;
    }
}
