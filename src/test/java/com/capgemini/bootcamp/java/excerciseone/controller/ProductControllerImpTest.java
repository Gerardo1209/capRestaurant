package com.capgemini.bootcamp.java.excerciseone.controller;

import com.capgemini.bootcamp.java.excerciseone.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;
import com.capgemini.bootcamp.java.excerciseone.repository.ProductRepository;
import com.capgemini.bootcamp.java.excerciseone.service.ProductService;
import com.capgemini.bootcamp.java.excerciseone.service.ProductServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerImpTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

    private ProductEntity productEntity;

    private ProductObject voidProductEntity;

    private ProductObject productObject;

    private ProductController productController;

    private List<ProductEntity> productEntityList;

    @BeforeEach
    void configuration(){
        voidProductEntity = new ProductObject();
        productEntity = new ProductEntity("Test", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "This is a test entity", 20.2, "test.png");
        productObject = new ProductObject(0,"Test", "Test", 20.2, "test.png");

        productEntityList = new ArrayList<>();
        productEntityList.add(productEntity);

        productService = new ProductServiceImp(productRepository);
        productController = new ProductControllerImp(productService);
    }

    @Test
    void create() {
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);
        ProductObject product = productController.create(productObject).getBody();
        assert product != null;
        assertEquals(product.getName(), productEntity.getName());
    }

    @Test
    void createFail() {
        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);
        assertThrows(Exception.class, () -> productController.create(voidProductEntity));
        voidProductEntity.setName("Test");
        assertThrows(Exception.class, () -> productController.create(voidProductEntity));
        voidProductEntity.setDescription("Test");
        assertThrows(Exception.class, () -> productController.create(voidProductEntity));
        voidProductEntity.setImage("Test.png");
        assertThrows(Exception.class, () -> productController.create(voidProductEntity));
        voidProductEntity.setPrice(20.2);
        voidProductEntity.setId(5);
        assertThrows(Exception.class, () -> productController.create(voidProductEntity));
        voidProductEntity.setId(0);
        ProductObject product = productController.create(productObject).getBody();
        assert product != null;
        assertEquals(product.getName(), productEntity.getName());
    }

    @Test
    void getAll() {
        when(productRepository.findAll()).thenReturn(productEntityList);
        List<ProductObject> productObjects = this.productController.getAll().getBody();
        assert productObjects != null;
        assert !productObjects.isEmpty();
        assertEquals("Test", productObjects.get(0).getName());
    }
}