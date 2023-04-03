package com.productstorage.service;

import com.productstorage.model.dto.request.*;
import com.productstorage.model.dto.response.GenericResponse;
import com.productstorage.model.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    public ProductResponse createProduct(CreateProductRequest request);
    public GenericResponse addProductPiece(UpdateProductPieceRequest request);
    public GenericResponse extractionProductPiece(UpdateProductPieceRequest request);
    public GenericResponse updateProduct(UpdateProductRequest request);
    public GenericResponse deleteProduct(IdRequest request);
    public ProductResponse getById(IdRequest request);
    public Page<ProductResponse> getAll(Pageable pageable);
    public Page<ProductResponse> getByFilter(ProductFilterRequest request, Pageable pageable);
    public void checkLimitPiece(IdRequest request);
}
