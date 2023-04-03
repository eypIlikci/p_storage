package com.productstorage.util.mapper;

import com.productstorage.model.dto.request.CreateProductRequest;
import com.productstorage.model.dto.request.UpdateProductRequest;
import com.productstorage.model.dto.response.ProductResponse;
import com.productstorage.model.entity.Category;
import com.productstorage.model.entity.Product;
import com.productstorage.model.entity.Storage;
import org.springframework.stereotype.Component;

@Component
public class ProductModelMapper {
    public Product map(CreateProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPiece(request.getPiece());
        product.setLimitPiece(request.getLimitPiece());
        Category category = new Category();
        category.setId(request.getCategoryId());
        product.setCategory(category);
        Storage storage = new Storage();
        storage.setId(request.getStorageId());
        product.setStorage(storage);
        return product;
    }
    public ProductResponse map(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPiece(product.getPiece());
        response.setLimitPiece(product.getLimitPiece());
        if (product.getCategory()!=null)
        response.setCategoryId(product.getCategory().getId());
        if (product.getStorage()!=null)
        response.setStorageId(product.getStorage().getId());
        return response;
    }
    public void map(UpdateProductRequest request,Product product){
        product.setName(request.getName());
        product.setLimitPiece(request.getLimitPiece());
        Storage storage = new Storage();
        storage.setId(request.getStorageId());
        product.setStorage(storage);
        Category category = new Category();
        category.setId(request.getCategoryId());
        product.setCategory(category);
    }

}
