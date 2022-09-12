package com.service;

import com.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    ProductDTO create(ProductDTO ProductDto);
    ProductDTO update(ProductDTO ProductDto);
    void remove(List<Integer> id);
    List<ProductDTO> findAllByIdCategory(Integer idCategory);
}
