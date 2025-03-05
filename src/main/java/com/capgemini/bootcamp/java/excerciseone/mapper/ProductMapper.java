package com.capgemini.bootcamp.java.excerciseone.mapper;

import com.capgemini.bootcamp.java.excerciseone.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excerciseone.domain.object.ProductObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //Transform entity to object
    ProductObject productEntityToProductObject(ProductEntity productEntity);

    //Transform object to entity
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    ProductEntity productObjectToProductEntity(ProductObject productObject);

}
