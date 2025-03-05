package com.capgemini.bootcamp.java.excerciseone.repository;

import com.capgemini.bootcamp.java.excerciseone.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //Add any method needed additional


}
