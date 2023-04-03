package com.productstorage.aspect;

import com.productstorage.model.dto.request.IdRequest;
import com.productstorage.model.dto.request.UpdateProductPieceRequest;
import com.productstorage.model.dto.request.UpdateProductRequest;
import com.productstorage.service.HistoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryAspect {

    private HistoryService historyService;
    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.createProduct(..))")
    public void logCreateProduct(JoinPoint joinPoint){
        try {
            IdRequest request = (IdRequest) joinPoint.getArgs()[0];
            historyService.logCrateHistory(request);
        }catch (Exception e){

        }
    }

    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.deleteProduct(..))")
    public void logDeleteProduct(JoinPoint joinPoint){
        try {
            IdRequest request = (IdRequest) joinPoint.getArgs()[0];
            historyService.logDeleteHistory(request);
        }catch (Exception e){

        }
    }

    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.updateProduct(..))")
    public void logUpdateProduct(JoinPoint joinPoint){
        try {
            UpdateProductRequest request = (UpdateProductRequest) joinPoint.getArgs()[0];
            IdRequest idRequest=new IdRequest();
            idRequest.setId(request.getId());
            historyService.logDeleteHistory(idRequest);
        }catch (Exception e){

        }
    }
    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.addProductPiece(..))")
    public void logAddProduct(JoinPoint joinPoint){
        try {
            UpdateProductPieceRequest request = (UpdateProductPieceRequest) joinPoint.getArgs()[0];
            IdRequest idRequest=new IdRequest();
            idRequest.setId(request.getProductId());
            historyService.logDeleteHistory(idRequest);
        }catch (Exception e){

        }
    }

    @AfterReturning(value = "execution(* com.productstorage.service.ProductService.extractionProductPiece(..))")
    public void logExtractionProduct(JoinPoint joinPoint){
        try {
            UpdateProductPieceRequest request = (UpdateProductPieceRequest) joinPoint.getArgs()[0];
            IdRequest idRequest=new IdRequest();
            idRequest.setId(request.getProductId());
            historyService.logDeleteHistory(idRequest);
        }catch (Exception e){

        }
    }
}
