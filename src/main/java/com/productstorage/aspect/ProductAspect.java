package com.productstorage.aspect;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.request.UpdateProductPieceRequest;
import com.productstorage.service.ProductService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {
    private final ProductService productService;

    @Autowired
    public ProductAspect(ProductService productService) {
        this.productService = productService;
    }

    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.extractionProductPiece(..))")
    public void logCreateProduct(JoinPoint joinPoint){
        try {
            UpdateProductPieceRequest request = (UpdateProductPieceRequest) joinPoint.getArgs()[0];
            IdRequest idRequest=new IdRequest();
            idRequest.setId(request.getProductId());
            productService.checkLimitPiece(idRequest);
        }catch (Exception e){
        }
    }
}
