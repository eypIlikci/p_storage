package com.productstorage.controller;

import com.productstorage.model.dto.request.*;
import com.productstorage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(productService.getAll(pageable));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getByFilter(Pageable pageable, @Valid @NotNull ProductFilterRequest request){
        return ResponseEntity.ok(productService.getByFilter(request,pageable));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CreateProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }
    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam(value = "id",required = true)Long id){
        IdRequest request = new IdRequest();
        request.setId(id);
        return ResponseEntity.ok(productService.deleteProduct(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")Long id){
        IdRequest request = new IdRequest();
        request.setId(id);
        return ResponseEntity.ok(productService.getById(request));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProductRequest request){
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    @PatchMapping("/add")
    public ResponseEntity<?> addPiece(@RequestBody @Valid UpdateProductPieceRequest request){
        return ResponseEntity.ok(productService.addProductPiece(request));
    }

    @PatchMapping("/ex")
    public ResponseEntity<?> exPiece(@RequestBody @Valid UpdateProductPieceRequest request){
        return ResponseEntity.ok(productService.extractionProductPiece(request));
    }
}
