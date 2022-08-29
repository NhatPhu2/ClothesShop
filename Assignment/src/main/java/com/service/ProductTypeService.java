package com.service;

import com.DTO.ProductTypeDto;

import java.util.List;

public interface ProductTypeService {
    List<ProductTypeDto> findAll();
    ProductTypeDto findById(Integer id);
    void create(ProductTypeDto ProductTypeDto);
    void update(ProductTypeDto ProductTypeDto);
    void remove(Integer id);
}
