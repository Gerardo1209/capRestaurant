package com.capgemini.bootcamp.java.excerciseone.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

    private ProductEntity productEntity;
    private Timestamp timestamp;

    @BeforeEach
    void configuration(){
        timestamp = new Timestamp(System.currentTimeMillis());
        productEntity = new ProductEntity();
    }

    @Test
    void getCreated() {
        productEntity.setCreated(timestamp);
        assertEquals(timestamp, productEntity.getCreated());
    }

    @Test
    void getModified() {
        productEntity.setModified(timestamp);
        assertEquals(timestamp, productEntity.getModified());
    }
}