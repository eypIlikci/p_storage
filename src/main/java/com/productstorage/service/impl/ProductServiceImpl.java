package com.productstorage.service.impl;

import com.productstorage.dao.repo.ProductRepository;
import com.productstorage.dao.repo.specification.ProductSpecificationGenerator;
import com.productstorage.model.dto.request.*;
import com.productstorage.model.dto.response.GenericResponse;
import com.productstorage.model.dto.response.ProductResponse;
import com.productstorage.model.entity.Product;
import com.productstorage.service.CategoryService;
import com.productstorage.service.ProductService;
import com.productstorage.service.StorageService;
import com.productstorage.util.error.ErrorMessage;
import com.productstorage.util.error.ServiceException;
import com.productstorage.util.event.LimitPieceEvent;
import com.productstorage.util.mapper.ProductModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductModelMapper productModelMapper;
    private final CategoryService categoryService;
    private final StorageService storageService;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductModelMapper productModelMapper,
                              CategoryService categoryService,
                              StorageService storageService,
                              ApplicationEventPublisher publisher) {
        this.productRepository = productRepository;
        this.productModelMapper = productModelMapper;
        this.categoryService = categoryService;
        this.storageService = storageService;
        this.publisher = publisher;
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        validCreateProduct(request);
        Product product = productModelMapper.map(request);
        product = productRepository.save(product);
        return productModelMapper.map(product);
    }

    @Override
    public GenericResponse addProductPiece(UpdateProductPieceRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ServiceException(ErrorMessage.ID));
        product.setPiece(product.getPiece().add(request.getValue()));
        productRepository.save(product);
        return new GenericResponse();
    }

    @Override
    public GenericResponse extractionProductPiece(UpdateProductPieceRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ServiceException(ErrorMessage.ID));
        product.setPiece(product.getPiece().remainder(request.getValue()));
        productRepository.save(product);
        return new GenericResponse();
    }

    @Override
    public GenericResponse updateProduct(UpdateProductRequest request) {
        validUpdateProduct(request);
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ServiceException(ErrorMessage.ID));
        product.setName(request.getName());
        productModelMapper.map(request,product);
        productRepository.save(product);
        return new GenericResponse();
    }

    @Override
    public GenericResponse deleteProduct(IdRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new ServiceException(ErrorMessage.ID));
        productRepository.delete(product);
        return new GenericResponse();
    }

    @Override
    public ProductResponse getById(IdRequest request) {
        return productModelMapper.map(productRepository.findById(request.getId()).orElseThrow(() -> new ServiceException(ErrorMessage.ID)));
    }

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(product -> productModelMapper.map(product));
    }

    @Override
    public Page<ProductResponse> getByFilter(ProductFilterRequest request, Pageable pageable) {
        return productRepository
                .findAll(ProductSpecificationGenerator.filter(request),pageable)
                .map(product -> productModelMapper.map(product));
    }

    @Override
    public void checkLimitPiece(IdRequest request) {
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ServiceException(ErrorMessage.ID));
        if (product.getPiece().longValue()<product.getLimitPiece()){
            //limit threshold exceeded
            publisher.publishEvent(new LimitPieceEvent(product.getId()));
        }
    }

    private void validCreateProduct(CreateProductRequest request){
        Boolean isName = productRepository.isByName(request.getName());
        if (isName)
            throw new ServiceException(ErrorMessage.USED_NAME);
        checkCatAndStorageId(request.getCategoryId(), request.getStorageId());
    }
    private void validUpdateProduct(UpdateProductRequest request){
        boolean isName = productRepository.isByNameAndId(request.getName(), request.getId());
        if (isName)
            throw new ServiceException(ErrorMessage.USED_NAME);
        checkCatAndStorageId(request.getCategoryId(), request.getStorageId());
    }
    private void checkCatAndStorageId(Long categoryId,Long storageId){
        IdRequest storageIdR = new IdRequest();
        storageIdR.setId(storageId);
        storageService.getById(storageIdR);
        IdRequest catId = new IdRequest();
        catId.setId(categoryId);
        categoryService.getById(catId);
    }
}