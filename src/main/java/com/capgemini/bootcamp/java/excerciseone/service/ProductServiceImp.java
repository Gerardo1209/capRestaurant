package com.capgemini.bootcamp.java.excerciseone.service;

import com.capgemini.bootcamp.java.excerciseone.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;
import com.capgemini.bootcamp.java.excerciseone.mapper.ProductMapper;
import com.capgemini.bootcamp.java.excerciseone.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public ProductObject create(ProductObject productObject) {
        //Check data
        if(productObject.getName().isEmpty()) throw new IllegalArgumentException("The name is needed");
        if(productObject.getDescription().isEmpty()) throw new IllegalArgumentException(("The description is needed"));
        if(productObject.getImage().isEmpty()) throw new IllegalArgumentException("The image route is needed");
        if(productObject.getPrice() <= 0) throw new IllegalArgumentException("The price is needed and must be grater than 0");
        if(productObject.getId() != 0) throw new IllegalArgumentException("The id should be 0");

        ProductEntity productEntity = ProductMapper.INSTANCE.productObjectToProductEntity(productObject);

        //Add timestamp and personal data
        productEntity.setCreated(new Timestamp(System.currentTimeMillis()));
        productEntity.setModified(new Timestamp(System.currentTimeMillis()));

        ProductEntity result = this.productRepository.save(productEntity);

        return ProductMapper.INSTANCE.productEntityToProductObject(result);
    }

    @Override
    public List<ProductObject> getAll() {
        List<ProductObject> productObjects = new ArrayList<>();

        List<ProductEntity> productEntities = this.productRepository.findAll();

        productEntities.forEach((productEntity ->
                productObjects.add(ProductMapper.INSTANCE.productEntityToProductObject(productEntity))));

        return productObjects;
    }
}
