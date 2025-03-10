package com.capgemini.bootcamp.java.excerciseone.controller;

import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    public ResponseEntity<ProductObject> create(ProductObject productObject);
    public ResponseEntity<List<ProductObject>> getAll();
}
