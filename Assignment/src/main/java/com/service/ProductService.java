package com.service;

import com.DTO.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Integer id);
    void create(ProductDto ProductDto);
    void update(ProductDto ProductDto);
    void remove(Integer id);
}
