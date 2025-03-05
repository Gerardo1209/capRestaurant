package com.capgemini.bootcamp.java.excerciseone.controller;

import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;

import java.util.List;

public interface ProdcutController {
    public ProductObject create(ProductObject productObject);
    public List<ProductObject> getAll();
}
