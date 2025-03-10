package com.capgemini.bootcamp.java.excerciseone.controller;


import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;
import com.capgemini.bootcamp.java.excerciseone.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductControllerImp implements ProductController{

    private final ProductService PRODUCT_SERVICE;

    public ProductControllerImp(ProductService productService) {
        this.PRODUCT_SERVICE = productService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductObject> create(ProductObject productObject) {
        return ResponseEntity.ok(this.PRODUCT_SERVICE.create(productObject));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductObject>> getAll() {
        return ResponseEntity.ok(this.PRODUCT_SERVICE.getAll());
    }
}
