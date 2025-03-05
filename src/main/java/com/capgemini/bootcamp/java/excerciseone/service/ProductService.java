package com.capgemini.bootcamp.java.excerciseone.service;

import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;

import java.util.List;

public interface ProductService {
    public ProductObject create(ProductObject productObject);
    public List<ProductObject> getAll();
}
