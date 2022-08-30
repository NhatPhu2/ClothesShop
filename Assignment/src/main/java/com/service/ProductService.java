package com.service;

import com.DTO.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Integer id);
    ProductDto create(ProductDto ProductDto);
    ProductDto update(ProductDto ProductDto);
    void remove(List<Integer> id);
}
